package com.example.scheduler.job;

import java.text.MessageFormat;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Component
public class SimpleJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap parameter = context.getJobDetail().getJobDataMap();
        JobParameter jobParameter = (JobParameter)parameter.get("parameter");
        System.out.println(MessageFormat.format("JobClass: {0}", getClass()));
        System.out.println(MessageFormat.format("JobName: {0}",jobParameter.getName()));
    }

}
