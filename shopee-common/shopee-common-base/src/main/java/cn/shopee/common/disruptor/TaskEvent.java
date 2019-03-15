package cn.shopee.common.disruptor;

/**
 * 
 * All rights Reserved, Designed By www.shopee.cn
 * 
 * @title: LongEvent.java
 * @package cn.gov.gzst.common.disruptor.sms
 * @description: 内容传递
 * @author: HuLiang
 * @date: 2017年6月7日 下午11:17:40
 * @version V1.0
 * @copyright: 2017 www.shopee.cn Inc. All rights reserved.
 *
 */
public class TaskEvent {
   private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}