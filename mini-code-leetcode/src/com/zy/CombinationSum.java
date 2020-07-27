package com.zy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * date:  2020-07-08 08:06
 *
 * @author zhengyao
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{10,1,2,7,6,1,5}, 8));
    }

    public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();

        int len = candidates.length;

        Arrays.sort(candidates);

        dfs(candidates, len, target, 0, new ArrayDeque<>(), list);
        return list;
    }

    private static void dfs(int[] candidates, int len, int residue, int begin, ArrayDeque<Integer> path, List<List<Integer>> list) {

        //递减为0
        if (residue==0){
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 在数组有序的前提下，剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            path.add(candidates[i]);

            dfs(candidates, len, residue - candidates[i], i, path, list);
            path.removeLast();
        }

    }
}
