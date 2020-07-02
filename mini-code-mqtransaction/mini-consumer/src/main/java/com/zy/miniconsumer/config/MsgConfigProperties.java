package com.zy.miniconsumer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: xiaoxu.nie
 * @date: 2018-12-04 14:15
 */
@Setter
@Getter
@Component
@Configuration
public class MsgConfigProperties {

    /**
     *
     * 读取配置文件
     * 后期可以改为nacos,apollo
     *
     */
    @Value("${spring.rocketmq.nameServer}")
    private String nameServer;

    @Value("${spring.rocketmq.producer.trans-group}")
    private String transGroup;

    @Value("${spring.rocketmq.trans-topic}")
    private String transTopic;

}
