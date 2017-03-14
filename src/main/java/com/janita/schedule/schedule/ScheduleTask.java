package com.janita.schedule.schedule;

import com.janita.schedule.util.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Janita on 2017/3/14
 * 定时任务
 * 有定时任务的类必须要注入到容器中
 * 否则无法执行计划
 */
@Component
public class ScheduleTask {

    @Scheduled(fixedRate = 5000)
    public void schedule(){
        System.out.println(DateUtil.fmtTime(System.currentTimeMillis()));
    }
}
