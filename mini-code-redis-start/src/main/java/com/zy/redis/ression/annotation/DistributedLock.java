package com.zy.redis.ression.annotation;

import java.lang.annotation.*;


@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DistributedLock {

    /**分布式锁名称*/
    String value() default "distributed-lock-redisson";
    /**锁超时时间,默认十秒*/
    int expireSeconds() default 10;
}


