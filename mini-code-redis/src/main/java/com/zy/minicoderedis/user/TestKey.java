package com.zy.minicoderedis.user;

import com.zy.minicoderedis.common.BasePrefix;

/**
 * date:  2020-07-02 11:52
 *
 * @author zhengyao
 */
public class TestKey extends BasePrefix {


    public TestKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static TestKey testKey = new TestKey(60, "test");
}
