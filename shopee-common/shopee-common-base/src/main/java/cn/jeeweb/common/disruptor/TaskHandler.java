package cn.shopee.common.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * 
 * All rights Reserved, Designed By www.shopee.cn
 * 
 * @title: SmsHandler.java
 * @package cn.gov.gzst.common.disruptor.sms
 * @description: 内容消费者
 * @author: HuLiang
 * @date: 2017年6月7日 下午11:20:32
 * @version V1.0
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 *
 */
public class TaskHandler implements WorkHandler<TaskEvent> {

	@Override
	public void onEvent(TaskEvent event) throws Exception {
		//运行任务
		event.getTask().run();
	}

}