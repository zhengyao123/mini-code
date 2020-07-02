package com.zy.miniconsumer.service.impl;

import com.zy.miniconsumer.enums.ErrorCodeEnum;
import com.zy.miniconsumer.exception.BusinessException;
import com.zy.miniconsumer.mapper.TransMsgConsumeRecordMapper;
import com.zy.miniconsumer.model.TransMsgConsumeRecord;
import com.zy.miniconsumer.service.ITransMsgConsumeRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class TransMsgConsumeRecordServiceImpl implements ITransMsgConsumeRecordService {

    @Resource
    private TransMsgConsumeRecordMapper transMsgConsumeRecordMapper;

    @Override
    public void createMsgRecord(TransMsgConsumeRecord consumeRecord) {
        int result = transMsgConsumeRecordMapper.insertSelective(consumeRecord);
        if (result <= 0) {
            throw new BusinessException(ErrorCodeEnum.TRANS_MSG_CONSUME_LOG_ADD_ERR.getMsg());
        }
    }

    @Override
    public void updateMsgRecord(TransMsgConsumeRecord consumeRecord) {
        int result = transMsgConsumeRecordMapper.updateByPrimaryKeySelective(consumeRecord);
        if (result <= 0) {
            throw new BusinessException(ErrorCodeEnum.TRANS_MSG_CONSUME_LOG_ADD_ERR.getMsg());
        }
    }

    @Override
    public TransMsgConsumeRecord findMsgRecordByTransId(String transId) {
        return transMsgConsumeRecordMapper.findTransMsgRecordByTransId(transId);
    }

    @Override
    public TransMsgConsumeRecord findMsgRecordByMsgId(String msgId) {
        return transMsgConsumeRecordMapper.findTransMsgRecordByMsgId(msgId);
    }
}
