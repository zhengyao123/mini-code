package com.zy.minicodeluban.jvm.six;

public class StackAlloc {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            alloc();
        }

        long end = System.currentTimeMillis();

        System.out.println((end - start) + " ms");

        while (true);
    }

    public static void alloc() {
        StackAlloc obj = new StackAlloc();
    }
}
