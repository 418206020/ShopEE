package cn.shopee.generator.service;

import cn.shopee.common.mybatis.mvc.service.ICommonService;
import cn.shopee.generator.common.data.DbTableInfo;
import cn.shopee.generator.common.exception.GenerationException;
import cn.shopee.generator.entity.Scheme;
import cn.shopee.generator.entity.Table;
import cn.shopee.generator.entity.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface ITableService extends ICommonService<Table> {

    /**
     * 获得表列表
     *
     * @return
     */
    public List<DbTableInfo> getTableNameList(String soureid);

    /**
     * 代码生成
     *
     * @title: doGenerateCode
     * @description:代码生成
     * @return: void
     */
    public void generateCode(Scheme scheme, List<Template> templates, List<Template> allTemplates) throws IOException, GenerationException;

    /**
     * 代码生成
     *
     * @title: doGenerateCode
     * @description:代码生成
     * @return: void
     */
    public void importDatabase(Table table);

    public void dropTable(String tableid);

    /**
     * 数据库生成
     *
     * @title: syncDatabase
     * @description:数据库生成
     * @return: void
     */
    public void syncDatabase(String tableid) throws TemplateException, IOException;

    public void removeById(Serializable id);

    public List<Table> findSubTable(String tablename);
}
