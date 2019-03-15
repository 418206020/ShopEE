package cn.shopee.web.modules.demo.controller;

import cn.shopee.common.mvc.annotation.ViewPrefix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.shopee.common.mvc.controller.BaseController;

/**
 * 
 * All rights Reserved, Designed By www.shopee.cn
 * 
 * @title: FormDemoController.java
 * @package cn.shopee.web.modules.demo.controller
 * @description: 统计报表DEMO
 * @author: HuLiang
 * @date: 2017年5月18日 下午6:17:24
 * @version V1.0
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 *
 */

@Controller
@RequestMapping("${shopee.admin.url.prefix}/demo/echart")
@ViewPrefix("modules/demo/echart")
public class EchartDemoController extends BaseController {

	/**
	 * 
	 * @title: echart   
	 * @description: 统计 
	 * @return      
	 * @return: String
	 */
	@RequestMapping("/index")
	public String echart() {
		return display("index");
	}
 
}
