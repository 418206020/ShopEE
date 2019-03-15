/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package cn.shopee.web.security.shiro.session.mgt;

import cn.shopee.web.modules.sys.entity.UserOnline;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;

import cn.shopee.common.utils.IpUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * All rights Reserved, Designed By www.shopee.cn
 * @title:  OnlineSessionFactory.java   
 * @package cn.shopee.web.modules.sys.security.shiro.session.mgt
 * @description:    创建自定义的session， 添加一些自定义的数据 如 用户登录到的系统ip 用户状态（在线 隐身 强制退出） 等 比如当前所在系统等  
 * @author: HuLiang
 * @date:   2017年6月26日 下午5:57:39   
 * @version V1.0 
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 *
 */
public class OnlineSessionFactory implements SessionFactory {

	@Override
	public Session createSession(SessionContext initData) {
		OnlineSession session = new OnlineSession();
		if (initData != null && initData instanceof WebSessionContext) {
			WebSessionContext sessionContext = (WebSessionContext) initData;
			HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
			if (request != null) {
				session.setHost(IpUtils.getIpAddr(request));
				session.setUserAgent(request.getHeader("User-Agent"));

				//session.setSystemHost(request.getLocalAddr() + ":" + request.getLocalPort());
			}
		}
		return session;
	}

	public Session createSession(UserOnline userOnline) {
		return userOnline.getSession();
	}
}
