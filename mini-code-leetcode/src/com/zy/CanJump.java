package com.zy;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * date:  2020-07-28 07:40
 *
 * @author zhengyao
 */
public class CanJump {

    public static void main(String[] args) {
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
