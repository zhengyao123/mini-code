package com.zy.minicodeluban.jvm.five;

/**
 * Created By ziya
 * 2020/7/27
 *
 * 这四种写法在JVM中是如何存储的
 *
 */
public class TestStringConstitute {

    public static void main(String[] args) {
 //       test1();
   //    test2();
    //   test3();
    test4();
    }

    public static void test1() {
        String s1 = "1";
    }

    public static void test2() {
        String s1 = "2";
        String s2 = "2";
    }

    public static void test21() {
        String s1 = "21";
        String s2 = "22";
    }

    public static void test3() {
        String s1 = new String("3");
    }

    public static void test4() {
        String s1 = new String("4");
        String s2 = new String("4");
    }
}
