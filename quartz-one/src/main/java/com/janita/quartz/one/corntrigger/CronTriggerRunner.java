package com.janita.quartz.one.corntrigger;

import com.janita.quartz.one.job.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by Janita on 2017-03-21 16:20
 */
public class CronTriggerRunner {
    public static void main(String[] args){

        try {

            JobDetail jobDetail = new JobDetail("job1_2","jGroup", SimpleJob.class);
            CronTrigger cronTrigger = new CronTrigger("trigger1_2","tgroup1");
            CronExpression cronExpression = new CronExpression("0/5 * * * * ?");
            cronTrigger.setCronExpression(cronExpression);

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail,cronTrigger);

            scheduler.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
