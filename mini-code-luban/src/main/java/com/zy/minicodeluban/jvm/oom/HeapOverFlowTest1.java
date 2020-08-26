package com.zy.minicodeluban.jvm.oom;

import java.util.ArrayList;
import java.util.List;

public class HeapOverFlowTest1 {

    int[] intArr = new int[10];

    public static void main(String[] args) {
        List<HeapOverFlowTest1> objs = new ArrayList<>();

        for (;;) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            objs.add(new HeapOverFlowTest1());
        }
    }
}
