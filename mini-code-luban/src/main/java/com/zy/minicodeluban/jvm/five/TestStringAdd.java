package com.zy.minicodeluban.jvm.five;

/**
 * Created By ziya
 * 2020/8/11
 */
public class TestStringAdd {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String s1 = "1";
        String s2 = "1";

        String s = s1 + s2;

        System.out.println(s);
    }

    public static void test2() {
        String s1 = "1";
        String s2 = new String("1");

        String s = s1 + s2;


    }
}
