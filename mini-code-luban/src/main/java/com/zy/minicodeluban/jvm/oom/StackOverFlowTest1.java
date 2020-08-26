package com.zy.minicodeluban.jvm.oom;

public class StackOverFlowTest1 {

    public static void test() {
        double a = 0.0;
        double b = 1.0;

        test();
    }

    public static void main(String[] args) {
        StackOverFlowTest1.test();

        System.out.println("hi");
    }
}
