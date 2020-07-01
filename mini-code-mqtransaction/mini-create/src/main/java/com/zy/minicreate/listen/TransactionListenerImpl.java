package com.zy.minicreate.listen;

import com.zy.minicreate.enums.ProducerTranStepEnum;
import com.zy.minicreate.model.TransMsgStateRecord;
import com.zy.minicreate.service.ITransMsgStateRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * date:  2020-07-01 10:52
 *  基于代码的监听
 * @author zhengyao
 */
@Slf4j
@Service
public class TransactionListenerImpl implements TransactionListener {

    //消息记录，落库
    @Autowired
    private ITransMsgStateRecordService transMsgStateRecordService;

    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object o) {
        // 1. 记录初始状态事务消息
        TransMsgStateRecord msgStateRecord = convertMqMsgToRecord(msg);
        transMsgStateRecordService.createTransMsg(msgStateRecord);
        try {
            // TODO 2.执行本地业务代码后续补充
            Thread.sleep(100);
            // 3.业务执行成功：保存业务执行日志，此处模拟业务执行成功，保存日志是防止发送本地事务执行结果消息失败时MSQ服务向客户端发起查询做判断
            msgStateRecord.setTransState(ProducerTranStepEnum.COMMIT_MESSAGE.getCode());
        } catch (Exception e) {
            log.error("BIZ Executor Exception:{}", e);
            // 4.业务执行失败，记录消息事务状态
            msgStateRecord.setTransState(ProducerTranStepEnum.ROLLBACK_MESSAGE.getCode());
            transMsgStateRecordService.updateTransMsg(msgStateRecord);
            return LocalTransactionState.ROLLBACK_MESSAGE;

        }

        transMsgStateRecordService.updateTransMsg(msgStateRecord);
        return LocalTransactionState.COMMIT_MESSAGE;
    }


    /**
     * <p>RocketMQ 服务端检测到消息状态超时时，主动向producer发起查询事务状态请求，
     * 根据生产者返回事务状态决定MQ服务中的消息是rollback还是commit</p>
     * 该方法是防止producer发送给mq服务的消息丢失，提供给mq服务回查消息状态使用
     *
     * @param msg
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        String transactionId = msg.getTransactionId();
        //查询入库的状态
        TransMsgStateRecord msgStateRecord = transMsgStateRecordService.findMsgStateByTransId(transactionId);
        if (msgStateRecord == null) {
            return LocalTransactionState.UNKNOW;
        }
        Integer status = msgStateRecord.getTransState();
        if (null == status) {
            return LocalTransactionState.UNKNOW;
        }
        switch (status) {
            case 0:
                return LocalTransactionState.UNKNOW;
            case 1:
                return LocalTransactionState.COMMIT_MESSAGE;
            case 2:
                return LocalTransactionState.ROLLBACK_MESSAGE;
            default:
                return LocalTransactionState.COMMIT_MESSAGE;
        }
    }

    /**
     * 将mq事务消息转为事务消息记录
     *
     * @param msg
     * @return
     */
    private TransMsgStateRecord convertMqMsgToRecord(Message msg) {
        TransMsgStateRecord msgStateRecord = new TransMsgStateRecord();
        msgStateRecord.setTopic(msg.getTopic());
        msgStateRecord.setFlag(msg.getFlag());
        msgStateRecord.setMsgBody(new String(msg.getBody()));
        msgStateRecord.setMsgKeys(msg.getKeys());
        msgStateRecord.setMsgTags(msg.getTags());
        msgStateRecord.setTransId(msg.getTransactionId());
        msgStateRecord.setMsgUniqKey(msg.getProperty(MessageConst.PROPERTY_UNIQ_CLIENT_MESSAGE_ID_KEYIDX));
        msgStateRecord.setMsgGroup(msg.getProperty(MessageConst.PROPERTY_PRODUCER_GROUP));

        String tranMsg = msg.getProperty(MessageConst.PROPERTY_TRANSACTION_PREPARED);

        msgStateRecord.setMsgIsTran(StringUtils.isBlank(tranMsg) ? false : Boolean.parseBoolean(tranMsg));

        String msgWait = msg.getProperty(MessageConst.PROPERTY_WAIT_STORE_MSG_OK);

        msgStateRecord.setMsgIsWait(StringUtils.isBlank(msgWait) ? false : Boolean.parseBoolean(msgWait));
        msgStateRecord.setCreateTime(new Date());
        // 默认是预发送状态
        msgStateRecord.setTransState(ProducerTranStepEnum.UN_KNOW.getCode());

        return msgStateRecord;
    }
}
