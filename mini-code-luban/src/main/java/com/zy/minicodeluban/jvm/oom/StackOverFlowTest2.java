package com.zy.minicodeluban.jvm.oom;

public class StackOverFlowTest2 {

    private int val = 0;

    public void test() {
        val++;

        test();
    }

    public static void main(String[] args) {
        StackOverFlowTest2 test = new StackOverFlowTest2();

        try {
            test.test();
        } catch (Throwable t) {
          //  t.printStackTrace();
            System.out.println(test.val);
        }
    }
}
