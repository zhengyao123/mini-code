package com.zy.minicodeluban.jvm.five;

/**
 * Created By ziya
 * 2020/7/27
 *
 */
public class TestString {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test8_1();

//        test9();

//       while (true);
    }

    public static void test() {
        String s = "11";
    }

    public static void test1() {
        String s1 = "11";
        String s2 = "11";

        // 加了这句会发生什么
//        s1.intern();

        System.out.println(s1 == s2);
    }

    public static void test2() {
        String s1 = new String("");
        String s2 = new String("11");

        System.out.println(s1 == s2);
    }

    public static void test3() {
        String s1 = new String("11");
        String s2 = "11";

        System.out.println(s1 == s2);
    }

    public static void test4() {
        String s1 = "11";
        String s2 = "1" + "1";

        System.out.println(s1 == s2);
    }

    public static void test5() {
        String s1 = "1";
        String s2 = "1";
        String s3 = s1 + s2;
        String s4 = "11";

        System.out.println(s3 == s4);
    }

    public static void test6() {
        final String s1 = "1";
        final String s2 = "1";
        String s3 = s1 + s2;
        String s4 = "11";

        System.out.println(s3 == s4);
    }

    public static void test7() {
        String s1 = new String("1");
        String s2 = new String("1");
        String s3 = s1 + s2;

        // 加了这句会发生什么
        s3.intern();

        String s4 = "11";

        System.out.println(s3 == s4);
    }

    public static void test8() {
        String s1 = new StringBuilder("11").toString();

        s1.intern();

        String s2 = "11";

        System.out.println(s1 == s2);
    }

    public static void test8_1() {
        String s1 = new StringBuilder("1").append("1").toString();

        s1.intern();

        String s2 = "11";

        System.out.println(s1 == s2);
    }

    public static void test9() {
        String s = new String("11");

        s.intern();

        System.out.println(s);
    }

}
