package com.zy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * date:  2020-07-06 10:07
 *
 * @author zhengyao
 */
@Data
@ConfigurationProperties(prefix = "redisson.lock.server")
public class RedissonProperties {

    /**redis主机地址，ip：port，有多个用半角逗号分隔*/
    private String address;
    /**连接类型，支持standalone-单机节点，sentinel-哨兵，cluster-集群，masterslave-主从*/
    private String type;
    /**redis连接密码*/
    private String password;
    /**选取那个数据库*/
    private int database;
}
