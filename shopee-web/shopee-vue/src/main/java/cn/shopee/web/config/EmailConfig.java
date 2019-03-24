package cn.shopee.web.config;

import cn.shopee.web.modules.email.dao.EmailDaoImpl;
import cn.shopee.common.email.disruptor.EmailDao;
import cn.shopee.common.email.disruptor.EmailHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.dataact.shopee.modules.config
 * @title:
 * @description: 邮件发送配置
 * @author: HuLiang
 * @date: 2018/3/1 16:06
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
@Configuration
public class EmailConfig {

    @Bean
    public EmailDao emailDao(){
        EmailDao emailDao=  new EmailDaoImpl();
        return emailDao;
    }

    @Bean
    public EmailHelper emailHelper(EmailDao emailDao){
        EmailHelper emailHelper=  new EmailHelper();
        emailHelper.setHandlerCount(1);
        emailHelper.setBufferSize(1024);
        emailHelper.setEmailDao(emailDao);
        return emailHelper;
    }

}
