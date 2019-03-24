package cn.shopee.web.modules.sms.service.impl;

import cn.shopee.web.modules.sms.entity.SmsSendLog;
import cn.shopee.web.modules.sms.mapper.SmsSendLogMapper;
import cn.shopee.web.modules.sms.service.ISmsSendLogService;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.web.modules.sms.service.impl
* @title: 发送日志服务实现
* @description: 发送日志服务实现
* @author: HuLiang
* @date: 2018-09-14 09:47:53
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("smssendlogService")
public class SmsSendLogServiceImpl  extends CommonServiceImpl<SmsSendLogMapper,SmsSendLog> implements  ISmsSendLogService {

}