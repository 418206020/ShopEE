package cn.shopee.web.modules.sys.mapper;

import cn.shopee.web.modules.sys.entity.LoginLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.web.modules.sys.mapper
* @title: 登陆日志数据库控制层接口
* @description: 登陆日志数据库控制层接口
* @author: sys
* @date: 2018-09-28 11:31:36
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {

}