package com.dlh.springbootes.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author: dulihong
 * @date: 2019/3/19 11:55
 */
@PropertySource("classpath:user.properties")
@Component
public class TestProperties {

    @Autowired
    private Environment env;

    private String userName;


    public void get() {
        userName = env.getProperty("user_name");
    }

    public String getUserName() {
        return userName;
    }
}
