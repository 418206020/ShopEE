package cn.shopee.bbs.modules.posts.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.posts.service.IPostsCollectionService;
import cn.shopee.bbs.modules.posts.entity.PostsCollection;
import cn.shopee.bbs.modules.posts.mapper.PostsCollectionMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.modules.posts.service.impl
* @title: 收藏服务实现
* @description: 收藏服务实现
* @author: HuLiang
* @date: 2018-09-03 09:48:55
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("postscollectionService")
public class PostsCollectionServiceImpl  extends CommonServiceImpl<PostsCollectionMapper,PostsCollection> implements  IPostsCollectionService {
    @Override
    public Page<PostsCollection> selectCollectionPage(Page<PostsCollection> page, Wrapper<PostsCollection> wrapper) {
        wrapper.eq("1", "1");
        page.setRecords(baseMapper.selectCollectionList(page, wrapper));
        return page;
    }
}