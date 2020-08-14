package com.zy.minicodeluban.jvm.one.classload;

public class Test_8 {

    static {
        System.out.println("Test_8 Static Block");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.zy.minicodeluban.jvm.one.classload.Test_1_A");
    }
}
