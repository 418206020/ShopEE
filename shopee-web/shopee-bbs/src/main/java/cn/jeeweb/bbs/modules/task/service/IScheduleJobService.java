package cn.shopee.bbs.modules.task.service;


import cn.shopee.common.mybatis.mvc.service.ICommonService;
import cn.shopee.bbs.modules.task.entity.ScheduleJob;
import org.quartz.SchedulerException;

/**
 * @Title: 任务
 * @Description: 任务
 * @author shopee
 * @date 2017-05-09 23:22:51
 * @version V1.0
 *
 */
public interface IScheduleJobService extends ICommonService<ScheduleJob> {
	/**
	 * 
	 * @title: initSchedule
	 * @description: 初始化任务
	 * @throws SchedulerException
	 * @return: void
	 */
	void initSchedule();

	/**
	 * 更改状态
	 * 
	 * @throws SchedulerException
	 */
	void changeStatus(String jobId, String cmd);

	/**
	 * 更改任务 cron表达式
	 * 
	 * @throws SchedulerException
	 */
	void updateCron(String jobId);

	/**
	 * 执行一次
	 *
	 * @throws SchedulerException
	 */
	void runAJobNow(String jobId);

	/**
	 * 刷新任务
	 *
	 * @throws SchedulerException
	 */
	void refreshTask();
}
