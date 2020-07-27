package com.zy;

/**
 * date:  2020-07-14 08:05
 *
 * @author zhengyao
 */
public class FirstMissingPositive {
    public static void main(String[] args) {

    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            boolean has = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    has = true;
                    break;
                }
            }
            if (!has) {
                //没有找到这个数，直接返回
                return i;
            }
        }
        return nums.length + 1;
    }
}
