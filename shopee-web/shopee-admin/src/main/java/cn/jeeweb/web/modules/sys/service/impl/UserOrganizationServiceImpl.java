package cn.shopee.web.modules.sys.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.web.modules.sys.entity.UserOrganization;
import cn.shopee.web.modules.sys.mapper.UserOrganizationMapper;
import cn.shopee.web.modules.sys.service.IUserOrganizationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("userOrganizationService")
public class UserOrganizationServiceImpl extends CommonServiceImpl<UserOrganizationMapper, UserOrganization>
		implements IUserOrganizationService {

}
