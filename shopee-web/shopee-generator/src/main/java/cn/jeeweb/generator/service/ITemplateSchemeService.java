package cn.shopee.generator.service;

import cn.shopee.common.http.Response;
import cn.shopee.common.mybatis.mvc.service.ICommonService;
import cn.shopee.generator.entity.TemplateScheme;

import java.io.Serializable;

/**   
 * @Title: 模板方案
 * @Description: 模板方案
 * @author HuLiang
 * @date 2017-09-15 15:21:43
 * @version V1.0   
 *
 */
public interface ITemplateSchemeService extends ICommonService<TemplateScheme> {
    /**
     * 复制
     * @param id
     * @return
     */
    boolean copy(Serializable id);

    /**
     * 复制
     * @param id
     * @return
     */
    Response export(Serializable id);

    /**
     * 复制
     * @param json
     * @return
     */
    boolean loadImport(String json);
}

