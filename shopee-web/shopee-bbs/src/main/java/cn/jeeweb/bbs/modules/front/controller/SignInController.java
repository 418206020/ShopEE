package cn.shopee.bbs.modules.front.controller;

import cn.shopee.bbs.common.bean.ResponseError;
import cn.shopee.bbs.modules.posts.entity.Posts;
import cn.shopee.bbs.modules.sign.entity.SignInStatus;
import cn.shopee.bbs.modules.sign.service.ISignInStatusService;
import cn.shopee.bbs.modules.sys.service.IUserService;
import cn.shopee.bbs.modules.sign.entity.SignIn;
import cn.shopee.bbs.modules.sign.service.ISignInService;
import cn.shopee.common.http.Response;
import cn.shopee.common.mvc.controller.BaseBeanController;
import com.baomidou.mybatisplus.plugins.Page;
import com.qcloud.cos.sign.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * All rights Reserved, Designed By www.shopee.cn
 *
 * @version V1.0
 * @package cn.shopee.bbs.sign.controller
 * @title: 签到控制器
 * @description: 签到控制器
 * @author: HuLiang
 * @date: 2018-09-05 16:03:35
 * @copyright: 2018 www.shopee.cn Inc. All rights reserved.
 */

@RestController("FrontSignInController")
@RequestMapping("sign/in")
public class SignInController extends BaseBeanController<SignIn> {

    @Autowired
    private ISignInService signInService;
    @Autowired
    private ISignInStatusService signInStatusService;
    /**
     * 签到
     * @return
     */
    @PostMapping("/sign")
    public Response sign() {
        Response response =  Response.ok("签到成功");
        try {
            SignInStatus  signInStatus = signInService.signIn();
            response.put("signed",Boolean.TRUE);
            response.put("experience",signInStatus.getExperience());
            response.put("days",signInStatus.getSignDay());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ResponseError.NORMAL_ERROR, e.getMessage());
        }
        return response;
    }
    /**
     * 签到
     * @return
     */
    @GetMapping("/list")
    public Response list() {
        Response response = Response.ok("保存成功");
        try {
            Page<SignIn> latestSignInPage = new com.baomidou.mybatisplus.plugins.Page<SignIn>(
                    1, 20);
            response.put("latestSign",signInService.selectLatestSignPage(latestSignInPage));
            Page<SignIn> toDaySignInPage = new com.baomidou.mybatisplus.plugins.Page<SignIn>(
                    1, 20);
            response.put("toDaySign",signInService.selectToDaySignPage(toDaySignInPage));
            Page<SignInStatus> signInStatusPage = new com.baomidou.mybatisplus.plugins.Page<SignInStatus>(
                    1, 20);
            response.put("totalLatestSign",signInStatusService.selectLatestSignPage(signInStatusPage));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
        }
        return response;
    }

    @GetMapping("{id}/delete")
    public Response delete(@PathVariable("id") String id) {
        try {
            signInService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ResponseError.NORMAL_ERROR,"删除失败");
        }
        return Response.ok("删除成功");
    }


}