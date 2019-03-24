package cn.shopee.web.modules.email.service.impl;

import cn.shopee.web.modules.email.entity.EmailTemplate;
import cn.shopee.web.modules.email.mapper.EmailTemplateMapper;
import cn.shopee.web.modules.email.service.IEmailTemplateService;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.web.modules.email.service.impl
* @title: 邮件模板服务实现
* @description: 邮件模板服务实现
* @author: HuLiang
* @date: 2018-09-12 10:59:18
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("emailtemplateService")
public class EmailTemplateServiceImpl  extends CommonServiceImpl<EmailTemplateMapper,EmailTemplate> implements  IEmailTemplateService {

}