package com.dlh.springbootes.my.queue;

import java.util.function.Consumer;

/**
 * @author: dulihong
 * @date: 2019/5/28 17:21
 */
public class TestConsumer implements Consumer {
    @Override
    public void accept(Object o) {
        System.out.println(o);
    }
}
