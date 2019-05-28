package com.dlh.springbootes.configuration;

import java.util.concurrent.ThreadFactory;

/**
 * @author: dulihong
 * @date: 2019/5/28 14:21
 */
public class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }

}
