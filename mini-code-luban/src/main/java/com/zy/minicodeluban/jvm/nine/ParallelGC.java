package com.zy.minicodeluban.jvm.nine;

import java.io.IOException;

/**
 * date:  2020-08-24 15:10
 *
 * @author zhengyao
 */
public class ParallelGC {
    public static void main(String[] args) throws IOException {
        byte[] b = null;
        for (int i = 0; i < 7; i++)
        {
            b = new byte[6 * 1024 * 1024];
        }
        System.in.read();
    }
}
