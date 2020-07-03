package com.zy.minicoderedis.lock.controller;

import com.zy.minicoderedis.lock.annotaions.RedisLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * date:  2020-07-03 11:25
 *
 * @author zhengyao
 */
@RestController
@RequestMapping("testone")
public class TestOne {

    @GetMapping("/test")
    @RedisLock(value = "redis-test")
    public void test() throws IOException {
        System.out.println("test redis lock begin");
        System.in.read();
    }
}
