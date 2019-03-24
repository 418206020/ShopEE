package cn.shopee.web.modules.email.service;

import cn.shopee.web.modules.email.entity.EmailSendLog;
import cn.shopee.common.mybatis.mvc.service.ICommonService;

import java.io.Serializable;
import java.util.List;

/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.web.modules.email.service
* @title: 邮件发送日志服务接口
* @description: 邮件发送日志服务接口
* @author: HuLiang
* @date: 2018-09-12 10:58:46
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
public interface IEmailSendLogService extends ICommonService<EmailSendLog> {

    /**
     * <p>
     *  邮件重发
     * </p>
     *
     * @param idList 主键ID列表
     * @return boolean
     */
    boolean retrySend(List<? extends Serializable> idList);
}