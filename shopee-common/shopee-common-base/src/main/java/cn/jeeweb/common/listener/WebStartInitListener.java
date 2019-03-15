package cn.shopee.common.listener;

import cn.shopee.common.utils.MessageUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * All rights Reserved, Designed By www.shopee.cn
 * @title:  WebStartInitListener.java   
 * @package cn.shopee.modules.common.listener
 * @description:   程序启动完成打印一个日志
 * @author: HuLiang
 * @date:   2017年5月7日 下午2:35:48   
 * @version V1.0 
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 *
 */
public class WebStartInitListener implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
		printKeyLoadMessage();
	}
	
	/**
	 * 获取Key加载信息
	 */
	public boolean printKeyLoadMessage(){
		StringBuilder sb = new StringBuilder();
		sb.append("\r\n======================================================================\r\n");
		sb.append("\r\n    欢迎使用 "+ MessageUtils.getMessage("platform.name")+" "+MessageUtils.getMessage("platform.version")+"  - "+MessageUtils.getMessage("platform.copyright")+"  "+MessageUtils.getMessage("platform.website")+"\r\n");
		sb.append("\r\n======================================================================\r\n");
		System.out.println(sb.toString());
		return true;
	}
}