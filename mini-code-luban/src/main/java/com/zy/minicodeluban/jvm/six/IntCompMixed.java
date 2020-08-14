package com.zy.minicodeluban.jvm.six;

/**
 *
 *  -Xint       9894 ms
 *  -Xcomp      2411 ms
 *  -Xmixed     2638 ms
 *
 */
public class IntCompMixed {

    public static void main(String[] args) {
        long star = System.currentTimeMillis();

        test1(100000);

        long end = System.currentTimeMillis();

        System.out.println(end - star + " ms");

//        while (true);
    }

    public static void test1(int n){
        int num=0;
        boolean sign;
        for(int i=2;i<n;i++){
            if(i % 2 == 0 && i != 2  )  continue; //偶数和1排除
            sign=true;
            for (int j=2;j<i;j++){
                if(i%j==0){
                    sign=false;
                    break;
                }
            }
            if (sign){
                num++;
                /*         System.out.println(""+i);*/
            }
        }
    }
}
