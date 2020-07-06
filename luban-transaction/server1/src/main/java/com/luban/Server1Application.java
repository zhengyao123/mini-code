package com.luban;

import com.snowalker.lock.redisson.config.EnableRedissonLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRedissonLock
public class Server1Application {

    public static void main(String[] args) {
        SpringApplication.run(Server1Application.class, args);
    }
}
