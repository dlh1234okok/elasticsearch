package com.dlh.springbootes.delay;

import com.dlh.springbootes.my.queue.DelayGetWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @author: dulihong
 * @date: 2019/5/28 14:03
 */
@Component
public class DelayedConsumer{


    @Async
    public void consumer(DelayGetWith delayGetWith) {
        for (;;){
            try {
                delayGetWith.callback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
