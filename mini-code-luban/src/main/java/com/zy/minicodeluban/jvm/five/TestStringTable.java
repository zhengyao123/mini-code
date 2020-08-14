package com.zy.minicodeluban.jvm.five;

/**
 * Created By ziya
 * 2020/7/27
 *
 *  用于证明字符串常量池中不会出现相同的字符串
 */
public class TestStringTable {

    public static void main(String[] args) {
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
        String str4 = "4";
        String str5 = "5";

        String str11 = "1";
        String str12 = "2";
        String str13 = "3";
        String str14 = "4";
        String str15 = "5";
    }
}
