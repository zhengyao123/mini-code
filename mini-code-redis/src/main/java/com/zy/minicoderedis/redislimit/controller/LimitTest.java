package com.zy.minicoderedis.redislimit.controller;

import com.zy.minicoderedis.redislimit.annotations.AccessLimit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date:  2020-07-02 15:38
 *
 * @author zhengyao
 */
@RequestMapping("limit")
@RestController
public class LimitTest {

    @RequestMapping("/test")
    @AccessLimit(seconds = 10,maxCount = 2,needLogin = false)
    public void test(){
        System.out.println("来了小老弟");
    }
}
