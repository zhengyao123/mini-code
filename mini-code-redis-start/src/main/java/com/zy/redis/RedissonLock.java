package com.zy.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * date:  2020-07-06 14:04
 * 分布式锁实现基于Redisson
 * @author zhengyao
 */
@Slf4j
public class RedissonLock {
    RedissonManager redissonManager;

    public RedissonLock(RedissonManager redissonManager) {
        this.redissonManager = redissonManager;
    }

    public RedissonLock() {}
    /**
     * 加锁操作
     * @return
     */
    public boolean lock(String lockName, long expireSeconds) {
        RLock rLock = redissonManager.getRedisson().getLock(lockName);
        boolean getLock = false;
        try {
            getLock = rLock.tryLock(0, expireSeconds, TimeUnit.SECONDS);
            if (getLock) {
                log.info("获取Redisson分布式锁[成功],lockName={}", lockName);
            } else {
                log.info("获取Redisson分布式锁[失败],lockName={}", lockName);
            }
        } catch (InterruptedException e) {
            log.error("获取Redisson分布式锁[异常]，lockName=" + lockName, e);
            e.printStackTrace();
            return false;
        }
        return getLock;
    }

    /**
     * 解锁
     * @param lockName
     */
    public void release(String lockName) {
        redissonManager.getRedisson().getLock(lockName).unlock();
    }

    public RedissonManager getRedissonManager() {
        return redissonManager;
    }

    public void setRedissonManager(RedissonManager redissonManager) {
        this.redissonManager = redissonManager;
    }
}
