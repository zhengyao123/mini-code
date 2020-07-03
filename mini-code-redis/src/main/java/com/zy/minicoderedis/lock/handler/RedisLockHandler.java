package com.zy.minicoderedis.lock.handler;

import com.zy.minicoderedis.lock.annotaions.RedisLock;
import com.zy.minicoderedis.lock.lock.RedisDistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private RedisDistributedLock redisDistributedLock;

    @Pointcut("@annotation(com.zy.minicoderedis.lock.annotaions.RedisLock)")
    public void redisLock() {
    }

    @Around("@annotation(redisLock)")
    public void around(ProceedingJoinPoint joinPoint, RedisLock redisLock) {
        log.info("[开始]执行RedisLock环绕通知,获取Redis分布式锁开始");
        //todo   MethodSignature signature = (MethodSignature) joinPoint.getSignature(); 写法也可以
        String lockName = redisLock.value();

        //原本打算单例模式避免问题，但是发现单例过程初始化是new， 导致@Autowired 注入实力不能初始化，
        //所有改为注入，（不想整体改动）
        //RedisDistributedLock redisDistributedLock = RedisDistributedLock.getInstance();

        if (redisDistributedLock.lock(lockName)) {
            try {
                log.info("获取Redis分布锁[成功]");
                System.out.println("获取Redis分布锁[成功]");
                joinPoint.proceed();

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            log.info("释放Redis分布式锁[成功]");
            System.out.println("释放Redis分布式锁[成功]");
            redisDistributedLock.release(lockName);
        } else {
            System.out.println("sorry lock acquisition failed ");
            log.error("获取锁失败");
        }
    }
}
