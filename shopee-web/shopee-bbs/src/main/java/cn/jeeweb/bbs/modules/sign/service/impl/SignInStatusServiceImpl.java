package cn.shopee.bbs.modules.sign.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.sign.service.ISignInStatusService;
import cn.shopee.bbs.modules.sign.entity.SignInStatus;
import cn.shopee.bbs.modules.sign.mapper.SignInStatusMapper;
import cn.shopee.common.mybatis.mvc.wrapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.sign.service.impl
* @title: 登陆状态服务实现
* @description: 登陆状态状态服务实现
* @author: HuLiang
* @date: 2018-09-05 18:45:25
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("signinstatusService")
public class SignInStatusServiceImpl  extends CommonServiceImpl<SignInStatusMapper,SignInStatus> implements  ISignInStatusService {

    @Override
    public SignInStatus selectLastSignInByUid(String uid) {
        EntityWrapper<SignInStatus> entityWrapper=new EntityWrapper<>(SignInStatus.class);
        entityWrapper.eq("signUid",uid);
        entityWrapper.orderBy("lastSignTime");
        SignInStatus signInStatus = selectOne(entityWrapper);
        return signInStatus;
    }

    @Override
    public Page<SignInStatus> selectLatestSignPage(Page<SignInStatus> page) {
        page.setRecords(baseMapper.selectLatestSignList(page));
        return page;
    }
}