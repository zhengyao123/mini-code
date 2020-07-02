package com.zy.miniconsumer.config;

import com.zy.miniconsumer.listen.ConsumerTranMsgListener;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * date:  2020-07-02 09:12
 *
 * @author zhengyao
 */
@Configuration
public class MQConsumerConfig {

    @Autowired
    private MsgConfigProperties msgConfigProperties;

    @Autowired
    private ConsumerTranMsgListener consumerTranMsgListener;

    /**
     * Spring中注册一个消费者,设置监听器监听指定主题的消息
     *
     * @return
     * @throws MQClientException
     */
    @Bean
    public DefaultMQPushConsumer defaultMQPushConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(msgConfigProperties.getTransGroup());
        consumer.setNamesrvAddr(msgConfigProperties.getNameServer());

        //设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费；如果非第一次启动，那么按照上次消费的位置继续消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe(msgConfigProperties.getTransTopic(), "*");

        consumer.registerMessageListener(consumerTranMsgListener);
        consumer.start();
        return consumer;
    }
}
