package cn.shopee.web.modules.email.service;

import java.util.Map;

/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.modules.sys.service
* @title: 系统消息服务接口
* @description: 系统消息服务接口
* @author: HuLiang
* @date: 2018-09-03 15:10:32
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
public interface IEmailSendService {
    void send(String email, String code, Map<String, Object> datas);

    void send(String[] emails, String code, Map<String, Object> datas);

    void send(String eventId, String email, String code, Map<String, Object> datas);

    void send(String eventId, String[] emails, String code, Map<String, Object> datas);
}