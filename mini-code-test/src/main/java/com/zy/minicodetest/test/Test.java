package com.zy.minicodetest.test;

import com.zy.redis.ression.annotation.DistributedLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date:  2020-07-06 14:26
 *
 * @author zhengyao
 */
@RestController
@RequestMapping("/test")
public class Test {

    @DistributedLock(value = "redis-lock3", expireSeconds = 100001)
    @GetMapping("/demo")
    public void test(){
        System.out.println("hello world");
    }
}
