package com.dlh.springbootes.delay;

public interface BaseMethodCallback<T> {
    T onMethodDo() throws Exception;
}
