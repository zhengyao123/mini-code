package com.zy.minicodeluban.jvm.two;

/**
 * date:  2020-08-06 17:39
 *
 * @author zhengyao
 */
public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println("a :"+a);
        System.out.println("b :"+b);

        swap(a,b);
    }

    private static void swap(int a, int b) {
        System.out.println("a :"+a);
        System.out.println("b :"+b);

    }
}
