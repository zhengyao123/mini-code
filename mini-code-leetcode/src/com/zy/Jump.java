package com.zy;

/**
 * date:  2020-07-21 07:47
 *
 * @author zhengyao
 */
public class Jump {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    public static int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                //先找到调到最后一个数的前一个i+num[i]=4,再找前一位
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;

    }
}
