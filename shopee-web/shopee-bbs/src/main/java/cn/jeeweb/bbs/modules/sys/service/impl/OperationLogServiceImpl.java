package cn.shopee.bbs.modules.sys.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.sys.service.IOperationLogService;
import cn.shopee.bbs.modules.sys.entity.OperationLog;
import cn.shopee.bbs.modules.sys.mapper.OperationLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.modules.sys.service.impl
* @title: 操作日志服务实现
* @description: 操作日志服务实现
* @author: HuLiang
* @date: 2018-09-30 15:53:25
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("operationlogService")
public class OperationLogServiceImpl  extends CommonServiceImpl<OperationLogMapper,OperationLog> implements  IOperationLogService {

}