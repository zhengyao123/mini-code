package com.zy.minicoderedis.lock.annotaions;

import java.lang.annotation.*;

/**
 * date:  2020-07-02 17:48
 *
 * @author zhengyao
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RedisLock {

    String value() default "redis-lock";

}
