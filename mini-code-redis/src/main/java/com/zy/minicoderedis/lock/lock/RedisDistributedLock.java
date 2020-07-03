package com.zy.minicoderedis.lock.lock;

import com.zy.minicoderedis.common.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * date:  2020-07-02 18:24
 *
 * @author zhengyao
 */
@Slf4j
@Component
public class RedisDistributedLock implements DistributedLock {

    @Autowired
    public RedisService redisService;

    private volatile static RedisDistributedLock redisDistributedLock;

    public RedisDistributedLock() {
    }

    //单例模式
    public static RedisDistributedLock getInstance() {
        if (redisDistributedLock == null) {
            synchronized (RedisDistributedLock.class) {
                redisDistributedLock = new RedisDistributedLock();
            }
        }
        return redisDistributedLock;
    }

    /**
     * 加锁
     *
     * @param lockName
     * @return 返回true表示加锁成功，执行业务逻辑，执行完毕需要主动释放锁，否则就需要等待锁超时重新争抢
     * 返回false标识加锁失败，阻塞并继续尝试获取锁
     */
    @Override
    public boolean lock(String lockName) {
        log.info("开始获取Redis分布式锁流程,lockName={},CurrentThreadName={}", lockName, Thread.currentThread().getName());

        Boolean lock_result = redisService.setNx(RedisLock.redisLock, lockName);

        if (lock_result) {
            log.info("setNx获取分布式锁[成功],threadName={}", Thread.currentThread().getName());
            //todo 加上业务判断，如果业务没有执行完，可以适当增加锁时间
            return lock_result;
        } else {
            log.info("setNx获取分布式锁[失败],threadName={}", Thread.currentThread().getName());
        }
        return false;
    }


    @Override
    public boolean release(String lockName) {
        Boolean result = redisService.releaseDistributedLock(RedisLock.redisLock, lockName);
        if (result) {
            log.info("删除Redis分布式锁成功，锁已释放, key= :{}", lockName);
            return true;
        }
        log.info("删除Redis分布式锁失败，锁未释放, key= :{}", lockName);
        return false;
    }
}
