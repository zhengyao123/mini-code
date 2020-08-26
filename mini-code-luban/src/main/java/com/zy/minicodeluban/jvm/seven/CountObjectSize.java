package com.zy.minicodeluban.jvm.seven;

import org.openjdk.jol.info.ClassLayout;

public class CountObjectSize {

    int a = 10;
    int b = 20;

    public static void main(String[] args) {
        CountObjectSize object = new CountObjectSize();

        System.out.println(ClassLayout.parseInstance(object).toPrintable());
    }
}