package cn.shopee.web.modules.sms.service.impl;

import cn.shopee.web.modules.sms.entity.SmsTemplate;
import cn.shopee.web.modules.sms.mapper.SmsTemplateMapper;
import cn.shopee.web.modules.sms.service.ISmsTemplateService;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.web.modules.sms.service.impl
* @title: 短信模板服务实现
* @description: 短信模板服务实现
* @author: HuLiang
* @date: 2018-09-14 09:47:35
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("smstemplateService")
public class SmsTemplateServiceImpl  extends CommonServiceImpl<SmsTemplateMapper,SmsTemplate> implements  ISmsTemplateService {

}