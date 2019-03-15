package cn.shopee.common.hibernate.mvc.hibernate.dynamic.builder;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import cn.shopee.common.utils.EhCacheUtil;
import org.apache.commons.lang3.Validate;
import org.dom4j.Document;
import org.dom4j.Element;
import org.hibernate.internal.util.xml.MappingReader;
import org.hibernate.internal.util.xml.OriginImpl;
import org.hibernate.internal.util.xml.XmlDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import  cn.shopee.common.hibernate.mvc.hibernate.dynamic.data.Config;
import  cn.shopee.common.hibernate.mvc.hibernate.dynamic.data.StatementType;
import  cn.shopee.common.hibernate.mvc.hibernate.dynamic.exception.DynamicException;
import  cn.shopee.common.hibernate.mvc.hibernate.dynamic.resolver.DynamicStatementDTDEntityResolver;
import  cn.shopee.common.hibernate.mvc.hibernate.dynamic.utils.Utils;

/**
 * @author HuLiang
 * 
 */
public class DefaultDynamicHibernateStatementBuilder implements DynamicHibernateStatementBuilder, ResourceLoaderAware {
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultDynamicHibernateStatementBuilder.class);
	protected final static EhCacheUtil ehcacheUtil = new EhCacheUtil(Config.DYNAMIC_CACHE);
	private String[] fileNames = new String[0];
	private ResourceLoader resourceLoader;
	private EntityResolver entityResolver = new DynamicStatementDTDEntityResolver();
	/**
	 * 查询语句名称缓存，不允许重复
	 */
	private Set<String> nameCache = new HashSet<String>();

	public void setFileNames(String[] fileNames) {
		this.fileNames = fileNames;
	}

	@Override
	public void init() throws IOException {
		// clear name cache
		nameCache.clear();
		ehcacheUtil.removeAll();
		boolean flag = this.resourceLoader instanceof ResourcePatternResolver;
		for (String file : fileNames) {
			if (flag) {
				Resource[] resources = ((ResourcePatternResolver) this.resourceLoader).getResources(file);
				buildMap(resources);
			} else {
				Resource resource = ((ResourcePatternResolver) this.resourceLoader).getResource(file);
				buildMap(resource);
			}
		}
		// clear name cache
		nameCache.clear();
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	private void buildMap(Resource[] resources) throws IOException {
		if (resources == null) {
			return;
		}
		for (Resource resource : resources) {
			buildMap(resource);
		}
	}

	@SuppressWarnings({ "rawtypes" })
	private void buildMap(Resource resource) {
		InputSource inputSource = null;
		try {
			inputSource = new InputSource(resource.getInputStream());
			XmlDocument metadataXml = MappingReader.INSTANCE.readMappingDocument(entityResolver, inputSource,
					new OriginImpl("file", resource.getFilename()));
			if (isDynamicStatementXml(metadataXml)) {
				final Document doc = metadataXml.getDocumentTree();
				final Element dynamicHibernateStatement = doc.getRootElement();
				Iterator rootChildren = dynamicHibernateStatement.elementIterator();
				while (rootChildren.hasNext()) {
					final Element element = (Element) rootChildren.next();
					final String elementName = element.getName();
					putStatementToCacheMap(resource, element, elementName);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e.toString());
			throw new DynamicException(e);
		} finally {
			if (inputSource != null && inputSource.getByteStream() != null) {
				try {
					inputSource.getByteStream().close();
				} catch (IOException e) {
					LOGGER.error(e.toString());
					throw new DynamicException(e);
				}
			}
		}

	}

	private void putStatementToCacheMap(Resource resource, final Element element, String statementNode)
			throws IOException {
		String statementId = element.attribute("id").getText();
		// 放入缓存
		statementId = Utils.getCacheKeyByType(statementId, StatementType.fromString(statementNode));
		Validate.notEmpty(statementId);
		if (nameCache.contains(statementId)) {
			throw new DynamicException("重复的" + statementNode + "语句定义在文件:" + resource.getURI() + "中，必须保证name的唯一.");
		}
		nameCache.add(statementId);
		String queryText = element.getText().trim();
		ehcacheUtil.set(statementId, queryText);
	}

	private static boolean isDynamicStatementXml(XmlDocument xmlDocument) {
		return "mapper".equals(xmlDocument.getDocumentTree().getRootElement().getName());
	}
}