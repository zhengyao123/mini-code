package com.zy;

import com.zy.redis.ression.config.EnableRedissonLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRedissonLock
public class MiniCodeTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniCodeTestApplication.class, args);
    }

}
