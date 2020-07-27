package com.zy.minicoderedis.user;

import com.zy.minicoderedis.common.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * date:  2020-07-24 11:10
 *
 * @author zhengyao
 */
@RestController
public class BigMapTest {

    @Autowired
    RedisService redisService;

    @RequestMapping("/testBig")
    public String bigMapTest() {
        String uid = "001";
        redisService.setBigMap(TestKey.testKey, uid, 1l, true);
        redisService.setBigMap(TestKey.testKey, uid, 3l, true);
        redisService.setBigMap(TestKey.testKey, uid, 5l, true);
        redisService.setBigMap(TestKey.testKey, uid, 223l, true);
        return "OJBK";
    }

    @RequestMapping("/getbigMapTest")
    public Long getbigMapTest() {
        String uid = "001";
        Long aLong = redisService.getbigMap(TestKey.testKey, uid,true);
        return aLong;
    }
}
