package com.zy.strategy;

import com.zy.config.RedissonProperties;
import org.redisson.config.Config;

/**
 * date:  2020-07-06 09:59
 *
 * @author zhengyao
 */
public interface RedissonConfigStrategy {

    /**
     * 通过不同的redis配置 策略创建对应config
     * @param redissonProperties
     * @return
     */
    Config createRedissonConfig(RedissonProperties redissonProperties);
}
