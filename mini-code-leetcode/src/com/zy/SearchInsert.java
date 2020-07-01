package com.zy;

/**
 * date:  2020-07-01 07:46
 *
 * @author zhengyao
 */
public class SearchInsert {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int begin = 0, mid = 0, end = nums.length - 1;
        while (begin <= end) {
            mid = begin + (end - begin) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return begin;
    }
}
