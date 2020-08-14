package com.zy.minicodeluban.jvm.four;

import java.io.Serializable;
import java.util.HashMap;

/**
 * date:  2020-08-12 16:04
 *
 * @author zhengyao
 */
public class Test extends HashMap implements Serializable {
    private String name = "";
    private int x = 1;
    public Test(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Test haha = new Test(null);
        int nameLength = haha.getNameLength();
        System.out.println(nameLength);
    }

    public int getNameLength() {
        int y = 0;
        try {
            y = name.length();
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
            e.printStackTrace();
        }
        return y;
    }
}
