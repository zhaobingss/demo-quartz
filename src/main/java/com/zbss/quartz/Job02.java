package com.zbss.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Desc
 * @Auther zbss
 * @Date 2017-09-28 11:53
 */
public class Job02 implements Job{

	private Logger logger = LoggerFactory.getLogger(getClass());

	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		logger.info("runing job02 ...");
	}
}
