package com.zy.annotation;

import java.lang.annotation.*;

/**
 * date:  2020-07-06 14:09
 *
 * @author zhengyao
 */
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
