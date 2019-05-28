package com.dlh.springbootes;

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

    public String callback(){
        try {
            System.out.println(delayQueue.take());
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
