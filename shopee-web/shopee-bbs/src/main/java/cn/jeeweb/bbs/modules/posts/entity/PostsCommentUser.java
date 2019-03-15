package cn.shopee.bbs.modules.posts.entity;

import cn.shopee.bbs.modules.sys.entity.User;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.modules.posts.entity
 * @title:
 * @description: 评论用户
 * @author: HuLiang
 * @date: 2018/9/3 11:22
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 */
public class PostsCommentUser extends User {
   private Integer commentCount;

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
