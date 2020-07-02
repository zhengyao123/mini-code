package com.zy.minicoderedis.common;

/**
 * @author: zhengyao
 * @date: 2020/4/30 9:06
 */
public class BasePrefix implements KeyPrefix {

    private int expireSeconds;

    private String prefix;

    //0代表永不过期
    public BasePrefix(String prefix) {
        this(0, prefix);
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String classname = getClass().getSimpleName();
        return classname + ":" + prefix;
    }
}
