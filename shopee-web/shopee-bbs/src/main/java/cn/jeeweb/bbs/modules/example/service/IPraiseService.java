package cn.shopee.bbs.modules.example.service;

import cn.shopee.bbs.modules.example.entity.Example;
import cn.shopee.common.mybatis.mvc.service.ICommonService;
import cn.shopee.bbs.modules.example.entity.Praise;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.modules.example.service
* @title: 点赞服务接口
* @description: 点赞服务接口
* @author: HuLiang
* @date: 2018-09-04 16:46:49
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
public interface IPraiseService extends ICommonService<Praise> {
    /**
     *
     * @title: selectUserList
     * @description: 查找点赞列表
     * @return
     * @return: List<User>
     */
    List<Praise> selectPraiseList(String exampleId);

}