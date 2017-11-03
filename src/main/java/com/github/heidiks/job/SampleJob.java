package com.github.heidiks.job;

import com.github.heidiks.service.SampleService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@DisallowConcurrentExecution
public class SampleJob implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(SampleJob.class);

    @Autowired
    private SampleService service;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        LOG.info("Starting job");
        try {
            service.hello();
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("Finishing job");
    }
}
