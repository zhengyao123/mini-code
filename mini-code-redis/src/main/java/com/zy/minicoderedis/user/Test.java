package com.zy.minicoderedis.user;

import java.time.LocalDate;

/**
 * date:  2020-07-24 13:42
 *
 * @author zhengyao
 */
public class Test {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfMonth());
        int dayOfYear = now.getDayOfYear();
        System.out.println(dayOfYear);
    }
}
