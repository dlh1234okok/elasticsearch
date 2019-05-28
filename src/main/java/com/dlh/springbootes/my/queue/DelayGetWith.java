package com.dlh.springbootes.my.queue;

import com.dlh.springbootes.delay.DelayedConsumer;
import com.dlh.springbootes.delay.DelayedQueueConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.DelayQueue;

/**
 * @author: dulihong
 * @date: 2019/5/28 16:39
 */
@FunctionalInterface
public interface DelayGetWith {


    void callback();


}
