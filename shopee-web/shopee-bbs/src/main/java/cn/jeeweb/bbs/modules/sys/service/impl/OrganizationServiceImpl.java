package cn.shopee.bbs.modules.sys.service.impl;

import cn.shopee.bbs.modules.sys.mapper.OrganizationMapper;
import cn.shopee.bbs.modules.sys.service.IOrganizationService;
import cn.shopee.common.mybatis.mvc.service.impl.TreeCommonServiceImpl;
import cn.shopee.bbs.modules.sys.entity.Organization;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("organizationService")
public class OrganizationServiceImpl extends TreeCommonServiceImpl<OrganizationMapper, Organization, String>
		implements IOrganizationService {

	@Override
	public List<Organization> findListByUserId(String userid) {
		return baseMapper.findListByUserId(userid);
	}

}
