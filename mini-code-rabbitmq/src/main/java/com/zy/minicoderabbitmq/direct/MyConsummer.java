package com.zy.minicoderabbitmq.direct;

import com.rabbitmq.client.*;
import com.zy.minicoderabbitmq.util.ConnectionUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * date:  2020-07-27 13:52
 *
 * @author zhengyao
 */
public class MyConsummer {
    private final static String QUEUE_NAME = "test_queue_work";

    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";

    public static void main(String[] args) throws Exception {

        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" Waiting for message....");

        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "zy");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("Received message : '" + msg + "'");
                System.out.println("consumerTag : " + consumerTag);
                System.out.println("deliveryTag : " + envelope.getDeliveryTag());
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
