package com.zy.strategy;

import com.zy.config.RedissonProperties;
import com.zy.constant.GlobalConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.config.Config;

/**
 * date:  2020-07-06 11:21
 *
 * @author zhengyao
 */
@Slf4j
public class ClusterRedissonConfigStrategyImpl implements RedissonConfigStrategy {
    /**
     * 集群模式
     * @param redissonProperties
     * @return
     * 地址格式：
     *       cluster方式至少6个节点(3主3从，3主做sharding，3从用来保证主宕机后可以高可用)
     *       格式为: 127.0.0.1:6379,127.0.0.1:6380,127.0.0.1:6381,127.0.0.1:6382,127.0.0.1:6383,127.0.0.1:6384
     */
    @Override
    public Config createRedissonConfig(RedissonProperties redissonProperties) {
        Config config = new Config();
        try {
            String address = redissonProperties.getAddress();
            String password = redissonProperties.getPassword();
            String[] addrTokens = address.split(",");
            /**设置cluster节点的服务IP和端口*/
            for (int i = 0; i < addrTokens.length; i++) {
                config.useClusterServers()
                        .addNodeAddress(GlobalConstant.REDIS_CONNECTION_PREFIX.getConstant_value() + addrTokens[i]);
                if (StringUtils.isNotBlank(password)) {
                    config.useClusterServers().setPassword(password);
                }
            }
            log.info("初始化[cluster]方式Config,redisAddress:" + address);
        } catch (Exception e) {
            log.error("cluster Redisson init error", e);
            e.printStackTrace();
        }
        return config;
    }
}
