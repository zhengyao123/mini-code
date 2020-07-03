package com.zy.minicoderedis;


import com.zy.minicoderedis.lock.annotaions.RedisLock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MiniCodeRedisApplicationTests {

    @Test
    @RedisLock(value = "test")
    void contextLoads() {
    }

}
