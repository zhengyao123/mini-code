package com.zy.minicodesecurity.common;

/**
 * date:  2020-07-07 17:41
 *
 * @author zhengyao
 */
public interface IStatus {
    /**
     * 状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 返回信息
     *
     * @return 返回信息
     */
    String getMessage();
}
