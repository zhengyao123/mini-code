package com.zy;

import java.util.Random;

/**
 * date:  2020-06-30 18:58
 *
 * @author zhengyao
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(createPassword());
    }

    public static  String createPassword() {

        char [] passwordChar=new char[8];;
        //生成随机 三个大写
        for (int i = 0; i < 3; i++) {
            Random ran = new Random();
            int random = ran.nextInt(26);
            char chArr = (char) ('A' + random);
            passwordChar[i]=chArr;
        }

        //生成随机2个小写
        for (int i = 3; i < 5; i++) {
            Random ran = new Random();
            int random = ran.nextInt(26);
            char chArr = (char) ('a' + random);
            passwordChar[i]=chArr;
        }

        //生成随机3个数字
        for (int i = 5; i < 8; i++) {
            Random ran = new Random();
            int random = ran.nextInt(9);
            char chArr = (char) ('0' + random);
            passwordChar[i]=chArr;
        }

        //随机排列
        char[] password = random(passwordChar);
        String s = new String(password);
        return s;

    }

    public static char []  random(char [] arr) {
        char [] arr2 =new char[arr.length];
        int count = arr.length;
        char cbRandCount = 0;// 索引
        int cbPosition = 0;// 位置
        int k =0;
        do {
            Random rand = new Random();
            int r = count - cbRandCount;
            cbPosition = rand.nextInt(r);
            arr2[k++] = arr[cbPosition];
            cbRandCount++;
            arr[cbPosition] = arr[r - 1];// 将最后一位数值赋值给已经被使用的cbPosition
        } while (cbRandCount < count);

        return arr2;
    }
}
