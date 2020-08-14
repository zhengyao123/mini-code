package com.zy.minicodeluban.jvm.one.classload;

public class Test_5 {

    public static void main(String[] args) {
        Test_5_A obj = new Test_5_A();
    }
}

class Test_5_A {
    static {
        System.out.println("Test_5_A Static Block");
    }
}
