package com.zy.minicoderedis.lock.lock;

import com.zy.minicoderedis.common.BasePrefix;

/**
 * date:  2020-07-03 10:32
 *
 * @author zhengyao
 */
public class RedisLock extends BasePrefix {

    public RedisLock(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static RedisLock redisLock = new RedisLock(60, "redisLock");
}
