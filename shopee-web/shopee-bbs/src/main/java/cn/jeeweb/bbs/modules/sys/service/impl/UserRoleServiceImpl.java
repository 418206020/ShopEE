package cn.shopee.bbs.modules.sys.service.impl;

import cn.shopee.bbs.modules.sys.entity.UserRole;
import cn.shopee.bbs.modules.sys.mapper.UserRoleMapper;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.sys.service.IUserRoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userRoleService")
public class UserRoleServiceImpl extends CommonServiceImpl<UserRoleMapper,UserRole> implements IUserRoleService {

}
