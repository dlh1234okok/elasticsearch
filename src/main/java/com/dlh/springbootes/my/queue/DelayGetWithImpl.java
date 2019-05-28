package com.dlh.springbootes.my.queue;

import com.dlh.springbootes.delay.DelayedQueueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @author: dulihong
 * @date: 2019/5/28 16:36
 */
@Component
public class DelayGetWithImpl implements DelayGetWith {

    @Autowired
    private DelayQueue<Delayed> delayQueue;

    public void callback() {
        try {
            DelayedQueueConfig take = (DelayedQueueConfig) delayQueue.take();
            System.out.println(take.getMsg());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
