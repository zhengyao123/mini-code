package com.zy.minicoderedis.common;

/**
 * @author: zhengyao
 * @date: 2020/4/30 9:05
 */
public interface KeyPrefix {
    int expireSeconds();
    String getPrefix();
}
