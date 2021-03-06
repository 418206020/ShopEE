package cn.shopee.generator.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.common.mybatis.mvc.wrapper.EntityWrapper;
import cn.shopee.common.utils.CacheUtils;
import cn.shopee.common.utils.StringUtils;
import cn.shopee.generator.entity.Scheme;
import cn.shopee.generator.entity.Table;
import cn.shopee.generator.entity.Template;
import cn.shopee.generator.entity.TemplateScheme;
import cn.shopee.generator.mapper.TemplateMapper;
import cn.shopee.generator.service.ITableService;
import cn.shopee.generator.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**   
 * @Title: 生成模板
 * @Description: 生成模板
 * @author shopee
 * @date 2017-09-15 15:10:12
 * @version V1.0   
 *
 */
@Transactional
@Service("templateService")
public class TemplateServiceImpl  extends CommonServiceImpl<TemplateMapper,Template> implements ITemplateService {

    @Autowired
    private ITableService tableService;

    @Override
    public boolean inlineEdit(Template template) {
        return insertOrUpdate(template);
    }

    /**
     * 测试
     * @param template
     */
    @Override
    public void test(Template template) {
        try {
            List<Template> templates=new ArrayList<>();
            templates.add(template);
            //所有模板
            List<Template> allTemplates=selectList(new EntityWrapper<Template>(Template.class).eq("scheme_id",template.getSchemeId()));
            EntityWrapper tableEntityWrapper=new EntityWrapper();
            tableEntityWrapper.eq("table_name","t_test_template");
            // 加一个状态

            Table table = tableService.selectOne(tableEntityWrapper);
            Scheme scheme = new Scheme();
            scheme.setEntityName("TestTemplate");
            scheme.setFunctionAuthor("测试");
            scheme.setFunctionDesc("测试");
            scheme.setFunctionName("测试");
            scheme.setTable(table);
            scheme.setTableType(table.getTableType());
            tableService.generateCode(scheme, templates,allTemplates);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
