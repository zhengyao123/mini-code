package com.zy.minicreate.service;

import com.zy.minicreate.model.TransMsgStateRecord;

/**
 * date:  2020-07-01 13:58
 *
 * @author zhengyao
 */
public interface ITransMsgStateRecordService {
    void createTransMsg(TransMsgStateRecord msgStateRecord);

    void updateTransMsg(TransMsgStateRecord msgStateRecord);

    TransMsgStateRecord findMsgStateByTransId(String transactionId);
}
