package com.zy.minicreate.service.impl;

import com.alibaba.fastjson.JSON;
import com.zy.minicreate.config.MsgConfigProperties;
import com.zy.minicreate.model.TransMsgStateRecord;
import com.zy.minicreate.service.ITransMsgService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

/**
 * date:  2020-07-01 11:49
 *
 * @author zhengyao
 */
@Service
@Slf4j
public class TransMsgServiceImpl implements ITransMsgService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private MsgConfigProperties msgConfigProperties;

    @Autowired
    private TransactionMQProducer transactionMQProducer;

    /**
     * 基于代码的监听
     * transactionMQProducer.setTransactionListener(transactionListener);
     * @param transMsg
     */
    @Override
    public void templateTransMsg(String transMsg) {

        long timeStamp = System.currentTimeMillis();
        String tags = "ZM-MQ:" + timeStamp;
        String keys = "ZM-MQ-KEY:" + timeStamp;
        String msg = "ZM-TRANS-MSG:" + timeStamp + ":" + transMsg;
        String orderId= UUID.randomUUID().toString();
        try {
            Message message = new Message(msgConfigProperties.getTransTopic(), tags, keys,
                    msg.getBytes(RemotingHelper.DEFAULT_CHARSET));

            // 向MQ发送消息
            SendResult sendResult = transactionMQProducer.sendMessageInTransaction(message, orderId);

            log.info("RocketMQ Send Msg Result:{}", sendResult);
        } catch (MQClientException | UnsupportedEncodingException e) {
            log.error("producerTransMsg:{}", e);
        }
    }


    public void templateTransMsg2(String transMsg) {
        try {
            long timeStamp = System.currentTimeMillis();
            String txGroupProducer = "Trans-Msg-Topic";
            String tags = "ZM-MQ:" + timeStamp;
            String keys = "ZM-MQ-KEYS:" + timeStamp;
            String msg = "ZM-TRANS-MSG:" + timeStamp + ":" + transMsg;

            TransMsgStateRecord transMsgStateRecord = new TransMsgStateRecord();
            transMsgStateRecord.setBizType(1);
            transMsgStateRecord.setCreateTime(new Date());
            transMsgStateRecord.setFlag(1);
            transMsgStateRecord.setMsgBody("amanxu-xiaoxu.nie");
            transMsgStateRecord.setMsgGroup(txGroupProducer);
            transMsgStateRecord.setMsgUniqKey(UUID.randomUUID().toString());
            transMsgStateRecord.setTransState(2);
            if (log.isDebugEnabled()) {
                log.debug("Debug transMsgStateRecord:{}", transMsgStateRecord);
            }
            log.debug("Debug transMsgStateRecord:{}", transMsgStateRecord);
            log.info("Info transMsgStateRecord:{}", transMsgStateRecord);
            log.warn("Warn transMsgStateRecord:{}", transMsgStateRecord);
            log.error("Error transMsgStateRecord:{}", transMsgStateRecord);
            String destination = new StringBuilder(txGroupProducer).append(":").append(tags).toString();
            org.springframework.messaging.Message<String> stringMessage = MessageBuilder.withPayload(transMsg).build();
            TransactionSendResult transactionSendResult = rocketMQTemplate.sendMessageInTransaction(txGroupProducer, destination, stringMessage, null);
            log.info("transactionSendResult:{}", JSON.toJSONString(transactionSendResult));
        } catch (MessagingException e) {
            log.info("MessagingException:{}", e);
        }
    }
}
