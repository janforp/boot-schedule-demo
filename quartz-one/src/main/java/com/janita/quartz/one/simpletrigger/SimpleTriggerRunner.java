package com.janita.quartz.one.simpletrigger;

import com.janita.quartz.one.job.SimpleJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Created by Janita on 2017-03-21 15:55
 */
public class SimpleTriggerRunner {

    public static void main(String[] args){
        try {
            JobDetail jobDetail = new JobDetail("job1_1","jgroup",SimpleJob.class);
            SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1","tgroup1");
            simpleTrigger.setStartTime(new Date());
            simpleTrigger.setRepeatInterval(2000);
            simpleTrigger.setRepeatCount(100);

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            scheduler.scheduleJob(jobDetail,simpleTrigger);
            scheduler.start();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
