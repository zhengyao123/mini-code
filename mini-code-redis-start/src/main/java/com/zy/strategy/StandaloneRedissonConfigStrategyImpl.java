package com.zy.strategy;

import com.zy.config.RedissonProperties;
import com.zy.constant.GlobalConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.config.Config;

/**
 * date:  2020-07-06 10:16
 *
 * @author zhengyao
 */
@Slf4j
public class StandaloneRedissonConfigStrategyImpl implements RedissonConfigStrategy {
    /**
     * 单机模式
     * @param redissonProperties
     * @return
     */
    @Override
    public Config createRedissonConfig(RedissonProperties redissonProperties) {

        Config config = new Config();
        try {
            String address = redissonProperties.getAddress();
            String password = redissonProperties.getPassword();
            int database = redissonProperties.getDatabase();
            String redisAddr = GlobalConstant.REDIS_CONNECTION_PREFIX.getConstant_value() + address;
            config.useSingleServer().setAddress(redisAddr);
            config.useSingleServer().setDatabase(database);
            if (StringUtils.isNotBlank(password)) {
                config.useSingleServer().setPassword(password);
            }
            log.info("初始化[standalone]方式Config,redisAddress:" + address);
        } catch (Exception e) {
            log.error("standalone Redisson init error", e);
            e.printStackTrace();
        }
        return config;
    }
}
