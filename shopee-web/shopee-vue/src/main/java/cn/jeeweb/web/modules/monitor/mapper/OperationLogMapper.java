package cn.shopee.web.modules.monitor.mapper;

import cn.shopee.web.modules.monitor.entity.OperationLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.web.modules.sys.mapper
* @title: 操作日志数据库控制层接口
* @description: 操作日志数据库控制层接口
* @author: HuLiang
* @date: 2018-09-30 15:53:25
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLog> {

}