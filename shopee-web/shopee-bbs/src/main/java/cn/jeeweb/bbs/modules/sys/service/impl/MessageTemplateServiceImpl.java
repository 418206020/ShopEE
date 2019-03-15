package cn.shopee.bbs.modules.sys.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.sys.service.IMessageTemplateService;
import cn.shopee.bbs.modules.sys.entity.MessageTemplate;
import cn.shopee.bbs.modules.sys.mapper.MessageTemplateMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.modules.sys.service.impl
* @title: 消息模版服务实现
* @description: 消息模版服务实现
* @author: HuLiang
* @date: 2018-09-03 15:10:10
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("messagetemplateService")
public class MessageTemplateServiceImpl  extends CommonServiceImpl<MessageTemplateMapper,MessageTemplate> implements  IMessageTemplateService {

}