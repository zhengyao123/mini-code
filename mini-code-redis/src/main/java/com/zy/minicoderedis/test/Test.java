package com.zy.minicoderedis.test;

import com.snowalker.lock.redisson.annotation.DistributedLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date:  2020-07-06 14:26
 *
 * @author zhengyao
 */
@RestController
@RequestMapping("/lock")
public class Test {

    @DistributedLock
    @GetMapping("/demo")
    public void test(){
        System.out.println("hello world");
    }
}
