package com.zy.minicoderedis.lock.lock;

/**
 * date:  2020-07-02 18:27
 *
 * @author zhengyao
 */
public interface DistributedLock {
    /**
     * 加锁
     *
     * @param lockName
     * @return
     */
    boolean lock(String lockName);

    /**
     * 解锁
     *
     * @param lockName
     */
    boolean release(String lockName);
}
