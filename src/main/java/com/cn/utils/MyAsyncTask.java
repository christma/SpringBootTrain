package com.cn.utils;


import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableAsync
@Slf4j
public class MyAsyncTask {

    @Async
    public void publishMsg(){
        try {
            Thread.sleep(10000);
            log.warn("开始执行任务 ：" + LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
