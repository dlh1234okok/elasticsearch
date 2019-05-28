package com.dlh.springbootes;

import com.dlh.springbootes.delay.DelayedConsumer;
import com.dlh.springbootes.delay.DelayedQueueConfig;
import com.dlh.springbootes.my.queue.DelayGetWithImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: dulihong
 * @date: 2019/5/28 15:58
 */
@Service
public class TestService {

    @Autowired
    private DelayedConsumer delayedConsumer;
    @Autowired
    private DelayGetWithImpl delayGetWith;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public void test() {
        int num = atomicInteger.get();
        atomicInteger.set(num + 1);
        long time = System.currentTimeMillis();
        System.out.println("发布时间:" + time);
        delayGetWith.put(100000, "哈哈哈");
        System.out.println("put ok...");
        delayedConsumer.consumer(() -> delayGetWith.callback());
    }

}
