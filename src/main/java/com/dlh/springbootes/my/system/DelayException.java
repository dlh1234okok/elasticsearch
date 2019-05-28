package com.dlh.springbootes.my.system;

/**
 * @author: dulihong
 * @date: 2019/5/28 16:09
 */
public class DelayException extends RuntimeException {

    private static final long serialVersionUID = -4739393032298497978L;

    public DelayException(String message) {
        super(message);
    }

    public DelayException(String message, Throwable cause) {
        super(message, cause);
    }
}
