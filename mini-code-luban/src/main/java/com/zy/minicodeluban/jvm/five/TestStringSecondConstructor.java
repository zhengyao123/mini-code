package com.zy.minicodeluban.jvm.five;

/**
 * Created By ziya
 * 2020/7/27
 */
public class TestStringSecondConstructor {

    public static void main(String[] args) {
        String s1 = new String(new char[]{'2', '2'}, 0, 2);

        String s2 = new String("22");
    }
}
