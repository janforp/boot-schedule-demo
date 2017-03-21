package com.janita.quartz.one.calendar;

import com.janita.quartz.one.job.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Janita on 2017-03-21 16:38
 */
public class CalendarExample {
    public static void main(String[] args) throws SchedulerException {

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        AnnualCalendar holidays = new AnnualCalendar();

        Calendar laborDay = new GregorianCalendar();
        laborDay.add(Calendar.MONTH,5);
        laborDay.add(Calendar.DATE,1);

        Calendar nationalDay = new GregorianCalendar();
        nationalDay.add(Calendar.MONTH,5);
        nationalDay.add(Calendar.DATE,1);

        ArrayList<Calendar> calendars = new ArrayList<>();
        calendars.add(laborDay);
        calendars.add(nationalDay);

        holidays.setDaysExcluded(calendars);

        scheduler.addCalendar("holidays",holidays,false,false);

        Date runDate = TriggerUtils.getDateOf(0,0,10,1,4);

        JobDetail job = new JobDetail("job1","group1", SimpleJob.class);
        SimpleTrigger trigger = new SimpleTrigger("trigger1","group1",
                runDate,null,SimpleTrigger.REPEAT_INDEFINITELY,60L * 60L * 1000L);

        trigger.setCalendarName("holidays");
        scheduler.scheduleJob(job,trigger);
        scheduler.start();

    }
}
