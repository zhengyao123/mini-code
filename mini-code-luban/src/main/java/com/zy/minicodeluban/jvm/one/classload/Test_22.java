package com.zy.minicodeluban.jvm.one.classload;

/**
 * 结果：
 *      1
 *      1
 */

public class Test_22 {

    public static void main(String[] args) {
        Test_22_A obj = Test_22_A.getInstance();

        System.out.println(Test_22_A.val1);
        System.out.println(Test_22_A.val2);
    }
}

class Test_22_A {

    public static int val1;

    public static Test_22_A instance = new Test_22_A();

     Test_22_A() {
        val1++;
        val2++;
    }

    public static int val2 = 1;

    public static Test_22_A getInstance() {
        return instance;
    }
}
