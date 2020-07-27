package com.zy;

/**
 * date:  2020-07-16 07:57
 *
 * @author zhengyao
 */
public class Multiply {
    public static void main(String[] args) {
        System.out.println(multiply("567", "789"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return "";
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int[] ans = new int[n1.length + n2.length];

        int start = 0;

        for (int i = n1.length - 1; i >= 0; i--) {
            int d = n1[i] - '0', k = start;
            for (int j = n2.length - 1; j >= 0; j--) {
                ans[k++] += (n2[j] - '0') * d;
            }
            start++;
        }
        int rem = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[i] += rem;
            rem = ans[i] / 10;
            ans[i] %= 10;
        }

        StringBuilder sb = new StringBuilder();
        int i = n1.length + n2.length - 1;
        while (ans[i] == 0)
            i--;
        while (i >= 0) {
            sb.append(ans[i]);
            i--;
        }
        return sb.toString();

    }
}
