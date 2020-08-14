package com.zy.minicodeluban.jvm.five;

/**
 * Created By ziya
 * 2020/7/27
 *
 * 双引号+双引号底层实现
 *
 */
public class TestString_5 {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String s1 = "1";
        String s2 = "1";

        String s = s1 + s2;

        new StringBuilder().append("1").append("1").toString();
    }
}
