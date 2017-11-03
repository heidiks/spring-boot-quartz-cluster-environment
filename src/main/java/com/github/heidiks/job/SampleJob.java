package com.github.heidiks.job;

import com.github.heidiks.service.SampleService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@DisallowConcurrentExecution
public class SampleJob implements Job {

    @Autowired
    private SampleService service;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("Starting job " + LocalDateTime.now().toString());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End job " + LocalDateTime.now().toString());
    }
}
