package cn.shopee.web.modules.sys.controller;

import cn.shopee.web.modules.oa.entity.OaNotification;
import cn.shopee.web.modules.oa.service.IOaNotificationService;
import cn.shopee.common.mybatis.mvc.wrapper.EntityWrapper;
import cn.shopee.common.utils.StringUtils;
import cn.shopee.web.utils.ThemeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
	@Autowired
	private IOaNotificationService oaNotificationService;

	/**
	 * 跳转到后台首页
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("redirect:/admin");
	}

	/**
	 * Coookie设置
	 */
	@RequestMapping(value = "theme/{theme}")
	public String themeCookie(@PathVariable String theme, HttpServletRequest request) {
		if (StringUtils.isNotBlank(theme)) {
			ThemeUtils.setTheme(theme);
		}
		return "redirect:" + request.getParameter("url");
	}

	@RequestMapping("main")
	public String main() {
		return "modules/sys/index/main";
	}

}
