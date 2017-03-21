package com.janita.quartz.one.simpletrigger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by Janita on 2017-03-21 15:54
 */
public class SimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("*******"+context.getTrigger().getName()+" triggered. time. is : " + new Date());
    }
}
