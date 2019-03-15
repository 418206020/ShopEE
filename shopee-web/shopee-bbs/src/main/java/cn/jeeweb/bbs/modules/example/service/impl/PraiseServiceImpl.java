package cn.shopee.bbs.modules.example.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.example.service.IPraiseService;
import cn.shopee.bbs.modules.example.entity.Praise;
import cn.shopee.bbs.modules.example.mapper.PraiseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.modules.example.service.impl
* @title: 点赞服务实现
* @description: 点赞服务实现
* @author: HuLiang
* @date: 2018-09-04 16:46:49
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("praiseService")
public class PraiseServiceImpl  extends CommonServiceImpl<PraiseMapper,Praise> implements  IPraiseService {
    @Override
    public List<Praise> selectPraiseList(String exampleId) {
        return baseMapper.selectPraiseList(exampleId);
    }
}