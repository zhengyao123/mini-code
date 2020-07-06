package com.zy.minicoderedis;

import com.snowalker.lock.redisson.config.EnableRedissonLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableRedissonLock
public class MiniCodeRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniCodeRedisApplication.class, args);
    }

}
