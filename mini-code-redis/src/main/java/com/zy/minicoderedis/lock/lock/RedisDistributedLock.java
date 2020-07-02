package com.zy.minicoderedis.lock.lock;

/**
 * date:  2020-07-02 18:24
 *
 * @author zhengyao
 */
public class RedisDistributedLock implements DistributedLock{
    @Override
    public boolean lock(String lockName) {
        return false;
    }

    @Override
    public boolean release(String lockName) {
        return false;
    }
}
