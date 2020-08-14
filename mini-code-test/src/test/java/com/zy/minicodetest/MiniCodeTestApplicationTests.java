package com.zy.minicodetest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class MiniCodeTestApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private static ExecutorService fixedPool3 = Executors.newFixedThreadPool(8);


    @Test
    void contextLoads() {

        RedisAtomicLong redisAtomicLong = new RedisAtomicLong("mini", redisTemplate.getConnectionFactory());

        for (int i = 0; i < 10; i++) {

            fixedPool3.execute(()->{
                int l = (int) redisAtomicLong.get();
                l++;
                redisAtomicLong.set(l);
            });
        }
    }
}
