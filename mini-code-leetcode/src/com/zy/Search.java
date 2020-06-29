package com.zy;

/**
 * date:  2020-06-29 07:57
 *
 * @author zhengyao
 */
public class Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    public static int search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1, mid = 0;

        while (begin <= end) {
            mid = begin + (end - begin) / 2;

            if (nums[mid] == target) return mid;

            if (nums[begin]<=nums[mid]){
                if (target>=nums[begin] && target<=nums[mid]){
                    end=mid-1;
                }else {
                    begin=mid+1;
                }
            }else {
                if (target>nums[mid] && target<=nums[end]){
                    begin=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
