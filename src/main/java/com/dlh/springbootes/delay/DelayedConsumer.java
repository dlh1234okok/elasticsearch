package com.dlh.springbootes.delay;

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

    @Autowired
    private DelayQueue<Delayed> delayQueue;

    @Async
    public void consumer(BaseMethodCallback baseMethodCallback) {
        while (true) {
            try {
                // System.out.println(delayQueue.take());
                baseMethodCallback.onMethodDo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
