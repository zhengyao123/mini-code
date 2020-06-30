package com.zy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * date:  2020-06-30 07:48
 *
 * @author zhengyao
 */
public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        //找左边最小
        int leftIdx = extremeInsertionIndex(nums, target, true);

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;

    }

    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
