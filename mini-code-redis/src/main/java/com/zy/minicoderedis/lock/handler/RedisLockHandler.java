package com.zy.minicoderedis.lock.handler;

import com.zy.minicoderedis.lock.annotaions.RedisLock;
import com.zy.minicoderedis.lock.lock.RedisDistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * date:  2020-07-02 17:50
 *
 * @author zhengyao
 */
@Aspect
@Component
@Slf4j
public class RedisLockHandler {

    @Pointcut("@annotation(com.zy.minicoderedis.lock.annotaions.RedisLock)")
    public void redisLock(){}

    @Around("@annotation(redisLock)")
    public void around(ProceedingJoinPoint joinPoint, RedisLock redisLock){
        //todo   MethodSignature signature = (MethodSignature) joinPoint.getSignature(); 写法也可以
        String lockName = redisLock.value();

        //RedisDistributedLock redisDistributedLock = RedisDistributedLock.getInstance();

    }
}
