package cn.shopee.bbs.modules.posts.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.posts.service.IPostsColumnService;
import cn.shopee.bbs.modules.posts.entity.PostsColumn;
import cn.shopee.bbs.modules.posts.mapper.PostsColumnMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.modules.bbs.service.impl
* @title: 帖子栏目服务实现
* @description: 帖子栏目服务实现
* @author: HuLiang
* @date: 2018-08-30 22:50:10
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("postscolumnService")
public class PostsColumnServiceImpl  extends CommonServiceImpl<PostsColumnMapper,PostsColumn> implements  IPostsColumnService {

}