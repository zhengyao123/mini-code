package com.zy.minicodeluban.jvm.one.classload;

public class Test_2 {

    public static void main(String[] args) {
        System.out.printf(Test_2_B.str);
    }
}
class Test_2_A {
    static {
        System.out.println("A Static Block");
    }
}
class Test_2_B extends Test_2_A {
    public static String str = "B str";

    static  {
        System.out.println("B Static Block");
    }
}