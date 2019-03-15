package cn.shopee.bbs.modules.sys.service.impl;

import cn.shopee.bbs.modules.sys.mapper.DictMapper;
import cn.shopee.bbs.modules.sys.service.IDictService;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.sys.entity.Dict;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("dictService")
public class DictServiceImpl extends CommonServiceImpl<DictMapper, Dict> implements IDictService {

	@Override
	public List<Dict> selectDictList() {
		return baseMapper.selectDictList();
	}

}
