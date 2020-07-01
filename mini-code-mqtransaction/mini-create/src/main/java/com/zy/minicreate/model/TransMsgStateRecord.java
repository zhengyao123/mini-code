package com.zy.minicreate.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * date:  2020-07-01 11:52
 *
 * @author zhengyao
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransMsgStateRecord implements Serializable {
    private Long id;

    private String topic;

    private Integer flag;

    private String msgBody;

    private String transId;

    private Integer transState;

    private String msgKeys;

    private Boolean msgIsTran;

    private String msgUniqKey;

    private Boolean msgIsWait;

    private String msgGroup;

    private String msgTags;

    private Integer bizType;

    private Date createTime;

    private Date updateTime;
}
