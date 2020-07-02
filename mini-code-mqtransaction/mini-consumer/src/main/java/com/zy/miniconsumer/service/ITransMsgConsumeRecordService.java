package com.zy.miniconsumer.service;


import com.zy.miniconsumer.model.TransMsgConsumeRecord;

public interface ITransMsgConsumeRecordService {

    /**
     * 创建事务消息消费记录
     *
     * @param consumeRecord
     */
    void createMsgRecord(TransMsgConsumeRecord consumeRecord);

    /**
     * 更新事务消息消费记录
     *
     * @param consumeRecord
     */
    void updateMsgRecord(TransMsgConsumeRecord consumeRecord);

    /**
     * 根据事务ID查询消费事务记录
     *
     * @param transId
     * @return
     */
    TransMsgConsumeRecord findMsgRecordByTransId(String transId);

    /**
     * 根据消息ID查询事务消息消费记录
     *
     * @param msgId
     * @return
     */
    TransMsgConsumeRecord findMsgRecordByMsgId(String msgId);
}
