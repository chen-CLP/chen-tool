package com.chen.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/4/23 14:53
 * @Version: v1.0
 */
public class ThreeSixEight {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        int maxRes = 0;
        int loc = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            pre[i] = i;
            for (int ii = 0; ii < i; ++ii) {
                if (nums[i] % nums[ii] == 0 && dp[i] < dp[ii] + 1) {
                    dp[i] = dp[ii] + 1;
                    pre[i] = ii;
                }
            }
            if (dp[i] > maxRes) {
                maxRes = dp[i];
                loc = i;
            }

        }
        res.add(nums[loc]);
        while (loc != 0 && loc != pre[loc]) {
            res.add(nums[pre[loc]]);
            loc = pre[loc];
        }
        return res;
    }
}
