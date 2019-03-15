package cn.shopee.bbs.modules.sys.service.impl;

import cn.shopee.bbs.modules.sys.mapper.DataSourceMapper;
import cn.shopee.bbs.modules.sys.service.IDataSourceService;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.sys.entity.DataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 数据源
 * @Description: 数据源
 * @author shopee
 * @date 2017-05-10 12:01:57
 * @version V1.0   
 *
 */
@Transactional
@Service("dataSourceService")
public class DataSourceServiceImpl  extends CommonServiceImpl<DataSourceMapper,DataSource> implements IDataSourceService {

}
