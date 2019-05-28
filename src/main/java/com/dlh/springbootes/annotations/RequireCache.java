package com.dlh.springbootes.annotations;

import java.lang.annotation.*;

/**
 * @author: dulihong
 * @date: 2019/3/22 15:03
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequireCache {
    // 用于存放形参名，数组，有多个形参则需要存多个
    String[] value() default "";

    // 用户存放key的开头
    String name() default "";

    // 如果参数为javabean，则需要传递，必须要有默认值否则必须写入
    Class[] type() default Object.class;
}