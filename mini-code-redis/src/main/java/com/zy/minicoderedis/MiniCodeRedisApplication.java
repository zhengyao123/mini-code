package com.zy.minicoderedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class MiniCodeRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniCodeRedisApplication.class, args);
    }

}
