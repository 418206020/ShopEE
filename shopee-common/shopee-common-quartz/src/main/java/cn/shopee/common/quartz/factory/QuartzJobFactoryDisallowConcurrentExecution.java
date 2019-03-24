package cn.shopee.common.quartz.factory;

import org.quartz.DisallowConcurrentExecution;

/**
 * 
 * All rights Reserved, Designed By www.shopee.cn
 * 
 * @title: QuartzJobFactoryDisallowConcurrentExecution.java
 * @package cn.shopee.core.quartz.factory
 * @description: 若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作
 * @author: HuLiang
 * @date: 2017年5月10日 上午12:24:52
 * @version V1.0
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 *
 */
@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution extends QuartzJobFactory {
}