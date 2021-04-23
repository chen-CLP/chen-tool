package com.chen.letcode;

import java.util.*;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/4/20 17:03
 * @Version: v1.0
 */
public class ThreeNine {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    public static void solve(int[] candidates, int sI, int re, List<Integer> resList, List<List<Integer>> res) {
        if (re == 0) {
            res.add(resList);
            return;
        } else if (re < 0 || sI >= candidates.length || candidates[sI] > re) {
            return;
        }
        for (int i = sI; i < candidates.length; ++i) {
            List<Integer> tList = new ArrayList<Integer>(resList);
            tList.add(candidates[i]);
            solve(candidates, i, re - candidates[i], tList, res);
        }
        return;
    }

    public static void main(String[] args) {
        System.out.println(1%3);
    }
}
