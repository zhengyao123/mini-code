package com.zy.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * date:  2020-07-06 11:41
 *
 * @author zhengyao
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RedissonAutoConfiguration.class)
public @interface EnableRedissonLock {
}
