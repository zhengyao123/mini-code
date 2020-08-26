package com.zy.minicodeluban.jvm.oom;

/**
 * date:  2020-08-26 11:37
 *
 * @author zhengyao
 */
public class CupHigh {
    public static void main(String[] args) {
        for (;;){
            new Thread(()->{
                System.out.println("new thread");
            }).start();
        }
    }
}
