package com.zy.minicodepay;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo(scanBasePackages  = "com.zy.minicodepay")
@SpringBootApplication
public class MiniCodePayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniCodePayApplication.class, args);
    }

}
