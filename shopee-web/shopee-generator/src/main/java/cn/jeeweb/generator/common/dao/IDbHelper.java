package cn.shopee.generator.common.dao;

import cn.shopee.generator.common.data.DbColumnInfo;
import cn.shopee.generator.common.data.DbTableInfo;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.generator.common.constant.cn.shopee.generator.common.dao
 * @title:
 * @description: 数据工具类
 * @author: HuLiang
 * @date: 2017/9/15 12:58
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
public interface IDbHelper extends Serializable {

    /**
     * 获取所有的表明
     *
     * @return
     */
    public List<DbTableInfo> getDbTables();

    /**
     * 通过表名获取所有的表名
     *
     * @param tableName
     * @return
     */
    public List<DbColumnInfo> getDbColumnInfo(String tableName);

    /**
     * 创建表
     * @param tableInfo
     * @throws TemplateException
     * @throws IOException
     */
    public void createTable(Map<String, Object> tableInfo) throws TemplateException, IOException;

    /**
     * 删除表
     * @param tableName
     */
    public void dropTable(String tableName);

}
