package com.dlh.springbootes.delay;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author: dulihong
 * @date: 2019/5/28 13:55
 */
public class DelayedQueueConfig implements Delayed {

    private Long delayedTime;

    private String msg;

    public DelayedQueueConfig(Long delayedTime,String msg) {
        this.delayedTime = delayedTime;
        this.msg = msg;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayedTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "DelayedQueueConfig{" +
                "delayedTime=" + delayedTime +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }
}
