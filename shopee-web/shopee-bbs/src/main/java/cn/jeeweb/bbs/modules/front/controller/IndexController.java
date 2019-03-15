package cn.shopee.bbs.modules.front.controller;

import cn.shopee.bbs.modules.posts.service.IPostsService;
import cn.shopee.common.mvc.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.modules.bbs.controller
 * @title: 评论控制器
 * @description: 评论控制器
 * @author: HuLiang
 * @date: 2018-08-29 17:51:13
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */
@RestController("FrontIndexController")
public class IndexController extends BaseController {

    @Autowired
    private IPostsService postsService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(Model model, HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("modules/front/index");
    }






}