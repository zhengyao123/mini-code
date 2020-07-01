package com.zy.minicreate.service.impl;

import com.zy.minicreate.enums.ErrorCodeEnum;
import com.zy.minicreate.exception.BusinessException;
import com.zy.minicreate.mapper.TransMsgStateRecordMapper;
import com.zy.minicreate.model.TransMsgStateRecord;
import com.zy.minicreate.service.ITransMsgStateRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * date:  2020-07-01 13:59
 *
 * @author zhengyao
 */
@Service
@Slf4j
public class TransMsgStateRecordServiceImpl implements ITransMsgStateRecordService {

    @Resource
    private TransMsgStateRecordMapper transMsgStateRecordMapper;

    @Override
    public void createTransMsg(TransMsgStateRecord msgStateRecord) {
        int result = transMsgStateRecordMapper.insertSelective(msgStateRecord);
        if (result <= 0) {
            throw new BusinessException(ErrorCodeEnum.TRANS_MSG_STATE_ADD_ERR.getCode(), ErrorCodeEnum.TRANS_MSG_STATE_ADD_ERR.getMsg());
        }
    }

    @Override
    public void updateTransMsg(TransMsgStateRecord msgStateRecord) {
        int result = transMsgStateRecordMapper.updateByPrimaryKeySelective(msgStateRecord);
        if (result <= 0) {
            throw new BusinessException(ErrorCodeEnum.TRANS_MSG_STATE_UPDATE_ERR.getCode(), ErrorCodeEnum.TRANS_MSG_STATE_UPDATE_ERR.getMsg());
        }
    }

    @Override
    public TransMsgStateRecord findMsgStateByTransId(String transId) {
        return transMsgStateRecordMapper.findRecordByTransId(transId);
    }
}
