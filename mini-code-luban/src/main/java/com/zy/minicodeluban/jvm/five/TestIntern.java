package com.zy.minicodeluban.jvm.five;

/**
 * Created By ziya
 * 2020/7/27
 *
 */
public class TestIntern {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();

        test5();

//        while (true);
    }

    public static void test1() {
        String s1 = "1";
        String s2 = "1";
        String s = s1 + s2;

        //s.intern();

        String str = "11";

        System.out.println(s == str);
    }

    public static void test2() {
        String s1 = new String("2");
        String s2 = new String("2");
        String s = s1 + s2;

        // 加了这句会发生什么
  //      s.intern();

        String str = "22";

        System.out.println(s == str);
    }

    public static void test3() {
        final String s1 = "3";
        final String s2 = "3";
        String s = s1 + s2;

        // 加了这句会发生什么
        //s.intern();

        String str = "33";

        System.out.println(s == str);
    }

    public static void test5() {
        final String s1 = new String("5");
        final String s2 = new String("5");

        String s = s1 + s2;

        // 加了这句会发生什么
//        s.intern();

        String str = "55";

        System.out.println(s == str);
    }

    public static void test4() {
        String s1 = new String("4");
        String s2 = "4";
        String s = s1 + s2;

        // 加了这句会发生什么
        s.intern();

        String str = "44";

        System.out.println(s == str);
    }
}
