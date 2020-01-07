package com.springcloud.learning.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author huaichuanli
 * @version 1.0
 * @date 2020/1/7
 */
@Component
public class SchedulerDemo {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	@Qualifier("importUserJob")
	private Job importUserJob;

	@Scheduled(fixedRate = 2000)
	public void launchJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        jobLauncher.run(importUserJob, new JobParametersBuilder().addLong("date", Instant.now().toEpochMilli())
                .addString("name", "张三丰").toJobParameters());
	}
}
