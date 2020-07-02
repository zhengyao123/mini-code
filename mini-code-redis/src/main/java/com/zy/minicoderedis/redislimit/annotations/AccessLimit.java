package com.zy.minicoderedis.redislimit.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * date:  2020-07-02 15:11
 *
 * @author zhengyao
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface AccessLimit {
    //时间
    int seconds();
    //次数
    int maxCount() default 5;
    //是否需要登录
    boolean needLogin() default false;
}
