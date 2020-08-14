package com.zy.minicodetest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * date:  2020-08-07 07:39
 *
 * @author zhengyao
 */

public class TestPipeline {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void test() {

    }
}
