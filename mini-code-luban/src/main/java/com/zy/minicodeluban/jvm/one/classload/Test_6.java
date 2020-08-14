package com.zy.minicodeluban.jvm.one.classload;

public class Test_6 {

    public static void main(String[] args) {
        System.out.println(Test_6_A.str);
    }
}

class Test_6_A {
    public static final String str = "A Str";

    static {
        System.out.println("Test_6_A Static Block");
    }
}
