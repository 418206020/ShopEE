package cn.shopee.bbs.modules.front.controller;

import cn.shopee.bbs.common.bean.ResponseError;
import cn.shopee.bbs.modules.posts.entity.PostsCollection;
import cn.shopee.bbs.modules.posts.service.IPostsCollectionService;
import cn.shopee.bbs.utils.UserUtils;
import cn.shopee.common.http.PageResponse;
import cn.shopee.common.http.Response;
import cn.shopee.common.mvc.controller.BaseBeanController;
import cn.shopee.common.mybatis.mvc.wrapper.EntityWrapper;
import cn.shopee.common.query.annotation.PageableDefaults;
import cn.shopee.common.query.data.PropertyPreFilterable;
import cn.shopee.common.query.data.Queryable;
import cn.shopee.common.query.utils.QueryableConvertUtils;
import cn.shopee.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.modules.posts.controller
 * @title: 收藏控制器
 * @description: 收藏控制器
 * @author: HuLiang
 * @date: 2018-09-03 09:48:55
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */
@RestController("FrontCollectionController")
@RequestMapping("/posts/comment/collection")
public class PostsCollectionController extends BaseBeanController<PostsCollection> {

    @Autowired
    private IPostsCollectionService postsCollectionService;

    @PostMapping("/find")
    public Response find(@RequestParam("postsId") String postsId) {
        Response response = Response.ok("查询成功");
        try {
            String uid = UserUtils.getUser().getId();
            EntityWrapper<PostsCollection> entityWrapper = new EntityWrapper(PostsCollection.class);
            entityWrapper.eq("collectionUid",uid);
            entityWrapper.eq("tid",postsId);
            if (postsCollectionService.selectCount(entityWrapper)>0){
                response.put("collection",true);
            }else{
                response.put("collection",false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ResponseError.NORMAL_ERROR,"收藏查询失败!<br />原因:" + e.getMessage());
        }
        return response;
    }

    @PostMapping("/add")
    public Response add(@RequestParam("postsId") String postsId) {
        try {
            String uid = UserUtils.getUser().getId();
            PostsCollection postsCollection = new PostsCollection();
            postsCollection.setCollectionTime(new Date());
            postsCollection.setCollectionUid(uid);
            postsCollection.setTid(postsId);
            postsCollectionService.insert(postsCollection);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ResponseError.NORMAL_ERROR,"收藏失败!<br />原因:" + e.getMessage());
        }
        return Response.ok("收藏成功");
    }

    @PostMapping("remove")
    public Response remove(@RequestParam("postsId") String postsId) {
        try {
            String uid = UserUtils.getUser().getId();
            EntityWrapper<PostsCollection> entityWrapper = new EntityWrapper(PostsCollection.class);
            entityWrapper.eq("collectionUid",uid);
            entityWrapper.eq("tid",postsId);
            postsCollectionService.delete(entityWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ResponseError.NORMAL_ERROR,"移除失败");
        }
        return Response.ok("移除成功");
    }


}