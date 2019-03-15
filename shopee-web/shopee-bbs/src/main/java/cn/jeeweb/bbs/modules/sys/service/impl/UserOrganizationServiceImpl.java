package cn.shopee.bbs.modules.sys.service.impl;

import cn.shopee.bbs.modules.sys.entity.UserOrganization;
import cn.shopee.bbs.modules.sys.mapper.UserOrganizationMapper;
import cn.shopee.bbs.modules.sys.service.IUserOrganizationService;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("userOrganizationService")
public class UserOrganizationServiceImpl extends CommonServiceImpl<UserOrganizationMapper, UserOrganization>
		implements IUserOrganizationService {

}
