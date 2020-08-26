package com.zy.minicodeluban.jvm.seven;

import org.openjdk.jol.info.ClassLayout;

public class CountSimpleObjectSizeTwo {

    static int[] arr = {0, 1, 2, 3, 4, 5, 6};
    static String str = "1";

    public static void main(String[] args) {
        CountSimpleObjectSizeTwo test1 = new CountSimpleObjectSizeTwo();

        System.out.printf(ClassLayout.parseInstance(test1.arr).toPrintable());

    }
}
