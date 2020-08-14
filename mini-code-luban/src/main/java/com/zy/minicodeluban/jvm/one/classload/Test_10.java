package com.zy.minicodeluban.jvm.one.classload;

public class Test_10 {
    public static void main(String[] args) {
        System.out.printf(Test_10_B.str);
    }
}

class Test_10_A {
    public static String str = "A str";

    static {
        System.out.println("A Static Block");
    }
}

class Test_10_B extends Test_10_A {
    static {
        str += "#11";

        System.out.println("B Static Block");
    }
}