package com.zy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * date:  2020-07-22 15:27
 *
 * @author zhengyao
 */
public class Demo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        long time = new Date().getTime();

        System.out.println(sdf.format(time));
    }
}
