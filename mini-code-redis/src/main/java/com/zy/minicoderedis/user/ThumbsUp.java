package com.zy.minicoderedis.user;

import com.zy.minicoderedis.common.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date:  2020-07-24 10:58
 *
 * @author zhengyao
 * <p>
 * redis Spring 数值类型实现点赞
 */
@RestController
public class ThumbsUp {
    @Autowired
    RedisService redisService;

    @RequestMapping("/test")
    public Long thumbsUp(){
        redisService.set(TestKey.testKey,"A", 1);
        return redisService.incr(TestKey.testKey,"A");
    }



}
