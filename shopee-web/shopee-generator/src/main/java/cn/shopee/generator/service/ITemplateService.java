package cn.shopee.generator.service;

import cn.shopee.common.mybatis.mvc.service.ICommonService;
import cn.shopee.common.mybatis.mvc.service.ICommonService;
import cn.shopee.generator.entity.Template;

import java.io.Serializable;

/**   
 * @Title: 生成模板
 * @Description: 生成模板
 * @author shopee
 * @date 2017-09-15 15:10:12
 * @version V1.0   
 *
 */
public interface ITemplateService extends ICommonService<Template> {

    /**
     * 复制
     * @param template
     * @return
     */
    boolean inlineEdit(Template template);

    /**
     *  模版测试
     * @param template
     * @return
     */
    void test(Template template);
}

