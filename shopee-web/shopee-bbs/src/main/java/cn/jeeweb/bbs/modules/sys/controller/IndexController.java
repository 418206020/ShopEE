package cn.shopee.bbs.modules.sys.controller;

import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.shopee.bbs.utils.ThemeUtils;
import cn.shopee.bbs.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.shopee.common.mybatis.mvc.wrapper.EntityWrapper;
import cn.shopee.common.utils.CookieUtils;
import cn.shopee.common.utils.StringUtils;
import cn.shopee.bbs.modules.oa.entity.OaNotification;
import cn.shopee.bbs.modules.oa.service.IOaNotificationService;

@Controller
public class IndexController {
	@Autowired
	private IOaNotificationService oaNotificationService;

	@RequestMapping(value = "${shopee.admin.url.prefix}",method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
		// 加载通知公告
		int oaNotificationCount = oaNotificationService
				.selectCount(new EntityWrapper<OaNotification>(OaNotification.class).eq("status", "1"));
		List<OaNotification> oaNotifications = oaNotificationService
				.selectList(new EntityWrapper<OaNotification>(OaNotification.class).eq("status", "1"));
		model.addAttribute("oaNotificationCount", oaNotificationCount);
		model.addAttribute("oaNotifications", oaNotifications);
		// 加载模版
		String theme = ThemeUtils.getTheme();
		return "modules/sys/index/index-" + theme;
	}

	/**
	 * Coookie设置
	 */
	@RequestMapping(value = "${shopee.admin.url.prefix}/theme/{theme}")
	public String themeCookie(@PathVariable String theme, HttpServletRequest request,
			HttpServletResponse response) {
		if (StringUtils.isNotBlank(theme)) {
			ThemeUtils.setTheme(theme);
		}
		return "redirect:" + request.getParameter("url");
	}

	@RequestMapping("${shopee.admin.url.prefix}/main")
	public String main() {
		return "modules/sys/index/main";
	}

}
