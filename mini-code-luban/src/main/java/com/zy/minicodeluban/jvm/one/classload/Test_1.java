package com.zy.minicodeluban.jvm.one.classload;

public class Test_1 {
    public static void main(String[] args) {
        System.out.printf(Test_1_B.str);

        while (true);
    }
}
class Test_1_A {
    public static String str = "A str";

    static {
        System.out.println("A Static Block");
    }
}
class Test_1_B extends Test_1_A {
    static {
        System.out.println("B Static Block");
    }
}