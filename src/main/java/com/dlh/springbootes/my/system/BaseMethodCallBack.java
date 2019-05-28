package com.dlh.springbootes.my.system;

/**
 * @author: dulihong
 * @date: 2019/5/28 16:08
 */
@FunctionalInterface
public interface BaseMethodCallBack<T>{

    T onMethodDo() throws DelayException;

}
