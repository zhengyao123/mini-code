package com.zy.minicoderedis.common;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: zhengyao
 * @date: 2020/4/29 20:47
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;//秒
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.poolMaxTotal}")
    private int poolMaxTotal;
    @Value("${spring.redis.poolMaxIdle}")
    private int poolMaxIdle;
    @Value("${spring.redis.poolMaxWait}")
    private int poolMaxWait;//秒

    @Bean
    public JedisPool JedisPoolFactory(){
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxIdle(poolMaxIdle);
        poolConfig.setMaxTotal(poolMaxTotal);
        poolConfig.setMaxWaitMillis(poolMaxWait * 1000);
        JedisPool jp = new JedisPool(poolConfig, host, port,
                timeout, password, 0);
        return jp;
    }
}
