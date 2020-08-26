package com.zy.minicodeluban.jvm.seven;

import org.openjdk.jol.info.ClassLayout;

public class CountSimpleObjectSize {

    static int[] arr = {1, 2, 3, 4};

    public static void main(String[] args) {
        CountSimpleObjectSize t = new CountSimpleObjectSize();
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
    }
}
