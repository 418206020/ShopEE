package cn.shopee.bbs.modules.sys.service.impl;

import cn.shopee.bbs.modules.sys.entity.DictGroup;
import cn.shopee.bbs.modules.sys.mapper.DictGroupMapper;
import cn.shopee.bbs.modules.sys.service.IDictGroupService;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("dictGroupService")
public class DictGroupServiceImpl extends CommonServiceImpl<DictGroupMapper,DictGroup> implements IDictGroupService {
}
