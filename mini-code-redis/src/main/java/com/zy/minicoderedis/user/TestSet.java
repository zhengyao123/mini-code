package com.zy.minicoderedis.user;

import com.zy.minicoderedis.common.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date:  2020-07-02 13:40
 *
 * @author zhengyao
 */
@RestController
@RequestMapping("/test")
public class TestSet {

    @Autowired
    RedisService redisService;

    @GetMapping("/demo")
    public void test(){
        Boolean zzzzz = redisService.set(TestKey.testKey, String.valueOf(System.currentTimeMillis()), "zzzzz");
        System.out.println(zzzzz);
    }
}
