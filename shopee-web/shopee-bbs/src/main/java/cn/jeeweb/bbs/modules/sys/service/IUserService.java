package cn.shopee.bbs.modules.sys.service;

import cn.shopee.bbs.modules.sys.entity.User;
import cn.shopee.common.mybatis.mvc.service.ICommonService;

/**
 * 
 * All rights Reserved, Designed By www.shopee.cn
 * 
 * @title: IUserService.java
 * @package cn.shopee.web.modules.sys.service
 * @description: 用户
 * @author: HuLiang
 * @date: 2017年7月11日 下午9:21:07
 * @version V1.0
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 *
 */
public interface IUserService extends ICommonService<User> {
	/**
	 * 判断密码正确
	 *
	 * @param userId
	 * @param nowPassword
	 */
	Boolean checkPassword(String userId, String nowPassword);
	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	void changePassword(String userId, String newPassword);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 根据Email查找用户
	 * 
	 * @param email
	 * @return
	 */
	User findByEmail(String email);

	/**
	 * 根据Email查找用户
	 * 
	 * @param phone
	 * @return
	 */
	User findByPhone(String phone);

	/**
	 * 根据Email查找用户
	 *
	 * @param realname
	 * @return
	 */
	User findByRealname(String realname);

	/**
	 * 注册用户
	 *
	 * @param user
	 * @return
	 */
	User register(User user);
}
