package com.dlh.springbootes.configuration;

import io.netty.util.concurrent.RejectedExecutionHandler;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author: dulihong
 * @date: 2019/5/28 13:58
 */
@SpringBootConfiguration
@EnableAsync
public class BeanFactory {

    @Bean("delayed")
    public DelayQueue<Delayed> delayedQueue() {
        DelayQueue<Delayed> queue = new DelayQueue<>();
        return queue;
    }

    /*@Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setQueueCapacity(20);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return threadPoolTaskExecutor;
    }*/


}
