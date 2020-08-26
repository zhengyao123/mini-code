package com.zy.minicodeluban.jvm.nine;

/**
 * date:  2020-08-24 13:57
 *
 * @author zhengyao
 */
public class ParNewGC {
    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 7; i++)
        {
            b = new byte[3 * 1024 * 1024];
        }
    }
}
