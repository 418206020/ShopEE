package cn.shopee.web.modules.oa.controller;


import cn.shopee.common.mvc.annotation.ViewPrefix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.shopee.common.mybatis.mvc.controller.BaseCRUDController;
import cn.shopee.common.security.shiro.authz.annotation.RequiresPathPermission;
import cn.shopee.web.modules.oa.entity.OaNotification;

/**   
 * @Title: 通知公告
 * @Description: 通知公告
 * @author shopee
 * @date 2017-06-10 17:15:17
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("oa/oanotification")
@ViewPrefix("modules/oa/oanotification")
@RequiresPathPermission("oa:oanotification")
public class OaNotificationController extends BaseCRUDController<OaNotification, String> {

}
