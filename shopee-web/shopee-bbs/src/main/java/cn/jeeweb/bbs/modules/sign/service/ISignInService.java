package cn.shopee.bbs.modules.sign.service;

import cn.shopee.bbs.modules.posts.entity.Posts;
import cn.shopee.bbs.modules.sign.entity.SignInStatus;
import cn.shopee.common.mybatis.mvc.service.ICommonService;
import cn.shopee.bbs.modules.sign.entity.SignIn;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import java.util.List;

/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.sign.service
* @title: 签到服务接口
* @description: 签到服务接口
* @author: HuLiang
* @date: 2018-09-05 16:03:35
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
public interface ISignInService extends ICommonService<SignIn> {
    /**
     * 判断昨天是否签到
     * @return
     */
    Integer countYesterdaySign(String userId);
    /**
     * 判断今天是否签到
     * @return
     */
    Integer countToDaySign(String userId);

    /**
     * 根据天数计算
     * @param day
     * @return
     */
    public Integer calculateExperience(Integer day);

    /**
     * 签到
     */
    SignInStatus signIn();

    Page<SignIn> selectToDaySignPage(Page<SignIn> page);

    Page<SignIn> selectLatestSignPage(Page<SignIn> page);


}