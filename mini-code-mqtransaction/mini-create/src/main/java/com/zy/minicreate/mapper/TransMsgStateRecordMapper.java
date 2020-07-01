package com.zy.minicreate.mapper;

import com.zy.minicreate.model.TransMsgStateRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TransMsgStateRecordMapper {

    int insertSelective(TransMsgStateRecord record);

    int updateByPrimaryKeySelective(TransMsgStateRecord record);

    /**
     * 根据事务ID查询事务消息日志
     *
     * @param transId
     * @return
     */
    TransMsgStateRecord findRecordByTransId(@Param("transId") String transId);

}