package com.zhaosha.springBootDemo.schedulDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rainsherry on 2018/5/31.
 */
@Component
public class ScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)//表明该方法是一个调度任务
    public void reportCurrentTime() {
        LOGGER.info("The time is now ()", dateFormat.format(new Date()));
    }

    /**
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     @Scheduled(cron=” /5 “) ：通过cron表达式定义规则
     */
}
