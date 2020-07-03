package com.zy;

/**
 * date:  2020-07-03 07:49
 *
 * @author zhengyao
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {

        StringBuilder s = new StringBuilder();
        int p1 = 0;
        int cur = 1;
        if (n == 1) return "1";

        String str = countAndSay(n - 1);


        for (cur = 1; cur < str.length(); cur++) {
            if (str.charAt(p1) != str.charAt(cur)) {// 如果碰到当前字符与前面紧邻的字符不等则更新此次结果
                int count = cur - p1;
                s.append(count).append(str.charAt(p1));
                p1 = cur;
            }
        }
        if (p1 != cur) {// 防止最后一段数相等，如果不等说明p1到cur-1这段字符串是相等的
            int count = cur - p1;
            s.append(count).append(str.charAt(p1));
        }
        return s.toString();

    }
}
