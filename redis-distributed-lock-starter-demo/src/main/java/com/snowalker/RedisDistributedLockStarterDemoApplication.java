package com.snowalker;

import com.snowalker.lock.redisson.config.EnableRedissonLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableRedissonLock
@SpringBootApplication
public class RedisDistributedLockStarterDemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RedisDistributedLockStarterDemoApplication.class, args);
	}


}
