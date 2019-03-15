package cn.shopee.bbs.modules.posts.service.impl;

import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.bbs.modules.posts.service.IPostsCommentPraiseService;
import cn.shopee.bbs.modules.posts.entity.PostsCommentPraise;
import cn.shopee.bbs.modules.posts.mapper.PostsCommentPraiseMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.bbs.modules.bbs.service.impl
* @title: 点赞服务实现
* @description: 点赞服务实现
* @author: HuLiang
* @date: 2018-08-29 17:51:39
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("postsCommentPraiseService")
public class PostsCommentPraiseServiceImpl extends CommonServiceImpl<PostsCommentPraiseMapper,PostsCommentPraise> implements IPostsCommentPraiseService {

}