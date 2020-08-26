package com.zy.minicodeluban.jvm.eight;

import java.io.IOException;

/**
 * date:  2020-08-20 08:58
 *
 * @author zhengyao
 */
public class ReferenceCountingAlgorithm {

    private Object instance;

    public ReferenceCountingAlgorithm() {
        byte [] m = new byte[20*1024*1024];
    }

    public static void main(String[] args) throws IOException {
        ReferenceCountingAlgorithm A = new ReferenceCountingAlgorithm();
        ReferenceCountingAlgorithm B = new ReferenceCountingAlgorithm();

        A.instance=B;
        B.instance=A;

        System.gc();

    }
}
