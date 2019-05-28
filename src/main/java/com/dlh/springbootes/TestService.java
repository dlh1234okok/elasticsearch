package com.dlh.springbootes;

import com.dlh.springbootes.delay.DelayedConsumer;
import com.dlh.springbootes.delay.DelayedQueueConfig;
import com.dlh.springbootes.my.queue.DelayGetWithImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @author: dulihong
 * @date: 2019/5/28 15:58
 */
@Service
public class TestService {

    @Autowired
    private DelayQueue<Delayed> delayQueue;
    @Autowired
    private DelayedConsumer delayedConsumer;
    @Autowired
    private DelayGetWithImpl delayGetWith;

    public void test() {
        delayQueue.put(new DelayedQueueConfig(System.currentTimeMillis() + 10000,"哈哈哈"));
        System.out.println("put ok...");
        delayedConsumer.consumer(() -> delayGetWith.callback());
    }

}
