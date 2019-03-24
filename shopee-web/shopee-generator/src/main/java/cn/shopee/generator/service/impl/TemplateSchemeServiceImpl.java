package cn.shopee.generator.service.impl;

import cn.shopee.common.http.Response;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.common.mybatis.mvc.wrapper.EntityWrapper;
import cn.shopee.common.utils.DateUtils;
import cn.shopee.generator.entity.Template;
import cn.shopee.generator.entity.TemplateScheme;
import cn.shopee.generator.mapper.TemplateSchemeMapper;
import cn.shopee.generator.service.ITemplateSchemeService;
import cn.shopee.generator.service.ITemplateService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**   
 * @Title: 模板方案
 * @Description: 模板方案
 * @author HuLiang
 * @date 2017-09-15 15:21:43
 * @version V1.0   
 *
 */
@Transactional
@Service("templateSchemeService")
public class TemplateSchemeServiceImpl  extends CommonServiceImpl<TemplateSchemeMapper,TemplateScheme> implements ITemplateSchemeService {

    @Autowired
    private ITemplateService templateService;

    @Override
    public boolean deleteById(Serializable id) {
        EntityWrapper entityWrapper = new EntityWrapper();
        entityWrapper.eq("scheme_id",id);
        templateService.delete(entityWrapper);
        return super.deleteById(id);
    }

    /**
     * 复制方案
     * @param id 方案ID
     * @return
     */
    @Override
    public boolean copy(Serializable id) {
        //方案
        TemplateScheme templateScheme = selectById(id);
        templateScheme.setTitle(templateScheme.getTitle()+"(copy)");
        templateScheme.setId(null);
        insert(templateScheme);
        //方案模版
        EntityWrapper templateEntityWrapper = new EntityWrapper();
        templateEntityWrapper.eq("scheme_id",id);
        List<Template> templateList = templateService.selectList(templateEntityWrapper);
        for (Template template: templateList) {
            template.setId(null);
            template.setSchemeId(templateScheme.getId());
        }
        if (templateList.size()>0) {
            templateService.insertBatch(templateList);
        }
        return Boolean.TRUE;
    }

    @Override
    public Response export(Serializable id) {
        Response response = Response.ok();
        //方案
        TemplateScheme templateScheme = selectById(id);
        templateScheme.setTitle(templateScheme.getTitle()+"(copy)");
        templateScheme.setId(null);
        response.put("templateScheme",templateScheme);
        //方案模版
        EntityWrapper templateEntityWrapper = new EntityWrapper();
        templateEntityWrapper.eq("scheme_id",id);
        List<Template> templateList = templateService.selectList(templateEntityWrapper);
        for (Template template: templateList) {
            template.setId(null);
            template.setSchemeId(templateScheme.getId());
        }
        response.put("templateList",templateList);
        return response;
    }

    @Override
    public boolean loadImport(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        //方案
        TemplateScheme templateScheme = JSONObject.parseObject(jsonObject.getString("templateScheme"),TemplateScheme.class);
        templateScheme.setTitle(templateScheme.getTitle()+"(导入)");
        insert(templateScheme);
        //方案模版
        List<Template> templateList = JSONObject.parseArray(jsonObject.getString("templateList"),Template.class);
        if (templateList.size()>0) {
            templateService.insertBatch(templateList);
        }
        return Boolean.TRUE;
    }
}
