package cn.shopee.bbs.modules.sys.service.impl;

import cn.shopee.bbs.modules.sys.mapper.RoleMenuMapper;
import cn.shopee.bbs.modules.sys.service.IRoleMenuService;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.sys.entity.RoleMenu;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roleMenuService")
public class RoleMenuServiceImpl extends CommonServiceImpl<RoleMenuMapper,RoleMenu> implements IRoleMenuService {

}
