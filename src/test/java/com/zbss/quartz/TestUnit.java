package com.zbss.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Desc
 * @Auther zbss
 * @Date 2017-09-28 11:59
 */
public class TestUnit {

	@Test
	public void test(){
		CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("*/2 * * * * ?");
		JobDetail job01 = JobBuilder.newJob(Job01.class).withIdentity("job01", "job").build();
		JobDetail job02 = JobBuilder.newJob(Job02.class).withIdentity("job02", "job").build();
		Trigger trigger01 = TriggerBuilder.newTrigger().withIdentity("trigger01", "trigger").withSchedule(cronScheduleBuilder).build();
		Trigger trigger02 = TriggerBuilder.newTrigger().withIdentity("trigger02", "trigger").withSchedule(cronScheduleBuilder).build();

		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.scheduleJob(job01, trigger01);// 添加任务一
			scheduler.start();

			Thread.sleep(5000);

			scheduler.scheduleJob(job02, trigger02);// 添加任务二

			Thread.sleep(10000);

			scheduler.deleteJob(job02.getKey());	// 删除任务二

			Thread.sleep(1000000);

		} catch (Exception e) {
			e.printStackTrace();
		}



	}

}
