package com.dlh.springbootes.configuration;

import com.dlh.springbootes.annotations.RequireCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
@Aspect
public class RequireCacheHandler {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Pointcut("@annotation(com.dlh.springbootes.annotations.RequireCache)")
    public void cut() {

    }

    @Around("cut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object result;
        // 通过pjp拿到方法签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();

        Signature signature = pjp.getSignature();
        // 拿到方法
        Method method = methodSignature.getMethod();
        // 获得目标对象的方法（因为该service实现了接口，动态代理会代理到接口上，接口并没有注解）
        Method realMethod = pjp.getTarget().getClass().getDeclaredMethod(signature.getName(),
                method.getParameterTypes());
        // 拿到注解
        RequireCache requireCache = realMethod.getAnnotation(RequireCache.class);
        // 拿到注解中的value和name和class类型
        String[] value = requireCache.value();
        String name = requireCache.name();
        Class[] types = requireCache.type();

        // 拿到参数值
        Object[] args = pjp.getArgs();
        // 定义StringBuffer用于存放key
        StringBuilder key = new StringBuilder();
        // 先将缓存开头名存入
        key.append(name);
        if (args.length > 0 && value.length == args.length) {
            for (String paramName : value) {
                for (Object arg : args) {
                    String str = "::" + paramName + ":";
                    key.append(str);
                    // 排除Integer和String类型等等..的参数,则为javabean对象
                    if (!(arg instanceof Integer) && !(arg instanceof String) && !(arg instanceof Long)) {
                        for (Class type : types) {
                            // 通过反射调用get方法拿到值
                            Field[] fields = type.getDeclaredFields();
                            for (Field field : fields) {
                                field.setAccessible(true);
                                String fieldName = field.getName();
                                // 排除序列化Id字段
                                if (!fieldName.equals("serialVersionUID")) {
                                    String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                                    Method declaredMethod = type.getDeclaredMethod(methodName);
                                    Object typeResult = declaredMethod.invoke(type.newInstance());
                                    String str2 = "";
                                    if (null != typeResult) {
                                        str2 = ":" + typeResult + "::";
                                    }
                                    // 将字段名和值一一对应
                                    key.append(fieldName);
                                    key.append(str2);
                                }
                                field.setAccessible(false);
                            }
                        }
                    } else {
                        key.append(arg);
                    }
                }
            }
        }

        // 拿到缓存中的内容
        Object obj = redisTemplate.opsForValue().get(key.toString());
        // 有缓存则直接返回
        if (null != obj) {
            return obj;
        }
        result = pjp.proceed();
        // 返回通知，存入缓存
        redisTemplate.opsForValue().set(key.toString(), result);
        return result;
    }
}