package cn.shopee.generator.service;

import cn.shopee.common.mybatis.mvc.service.ICommonService;
import cn.shopee.generator.common.dao.IDbHelper;
import cn.shopee.generator.entity.DataSource;

/**
 * @Title: 数据源
 * @Description: 数据源
 * @author shopee
 * @date 2017-05-10 12:01:57
 * @version V1.0   
 *
 */
public interface IDataSourceService extends ICommonService<DataSource> {
    /**
     * 获取Hepler
     * @param datasourid
     * @return
     */
    IDbHelper getDbHelper(String datasourid);

    void testConnect(DataSource dataSource);

}

