package cn.shopee.web.modules.task.service.impl;

import cn.shopee.web.modules.task.entity.ScheduleJobLog;
import cn.shopee.web.modules.task.mapper.ScheduleJobLogMapper;
import cn.shopee.web.modules.task.service.IScheduleJobLogService;
import cn.shopee.common.mybatis.mvc.service.impl.CommonServiceImpl;
import cn.shopee.common.quartz.callback.QuartzExecuteCallback;
import cn.shopee.common.quartz.data.ScheduleJob;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
* All rights Reserved, Designed By www.shopee.cn
*
* @version V1.0
* @package cn.shopee.web.modules.task.service.impl
* @title: 任务日志服务实现
* @description: 任务日志服务实现
* @author: HuLiang
* @date: 2018-09-17 14:25:19
* @copyright: 2018 www.shopee.cn Inc. All rights reserved.
*/
@Transactional
@Service("schedulejoblogService")
public class ScheduleJobLogServiceImpl
        extends CommonServiceImpl<ScheduleJobLogMapper,ScheduleJobLog>
        implements  IScheduleJobLogService,QuartzExecuteCallback{

    @Override
    public void onStart(ScheduleJob scheduleJob) {
        ScheduleJobLog scheduleJobLog = newJobLog(scheduleJob);
        scheduleJobLog.setJobMessage(scheduleJob.getJobName() + "运行开始!");
        scheduleJobLog.setStatus(ScheduleJobLog.SCHEDULE_JOB_LOG_RUN_NOMAL);
        insert(scheduleJobLog);
    }

    @Override
    public void onSuccess(ScheduleJob scheduleJob, String message) {
        ScheduleJobLog scheduleJobLog = newJobLog(scheduleJob);
        scheduleJobLog.setJobMessage(message);
        scheduleJobLog.setStatus(ScheduleJobLog.SCHEDULE_JOB_LOG_RUN_SUCCESS);
        insert(scheduleJobLog);
    }

    @Override
    public void onFailure(ScheduleJob scheduleJob, Exception e, String message) {
        ScheduleJobLog scheduleJobLog = newJobLog(scheduleJob);
        scheduleJobLog.setJobMessage(message);
        scheduleJobLog.setStatus(ScheduleJobLog.SCHEDULE_JOB_LOG_RUN_FAIL);
        scheduleJobLog.setExceptionInfo(e.getMessage());
        insert(scheduleJobLog);
    }

    private ScheduleJobLog newJobLog(ScheduleJob scheduleJob){
        ScheduleJobLog scheduleJobLog = new ScheduleJobLog();
        scheduleJobLog.setJobName(scheduleJob.getJobName());
        scheduleJobLog.setJobGroup(scheduleJob.getJobGroup());
        scheduleJobLog.setMethodName(scheduleJob.getMethodName());
        scheduleJobLog.setMethodParams(scheduleJob.getMethodParams());
        scheduleJobLog.setCreateTime(new Date());
        return scheduleJobLog;
    }
}