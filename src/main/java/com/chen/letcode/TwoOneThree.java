package com.chen.letcode;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/4/15 17:25
 * @Version: v1.0
 */
public class TwoOneThree {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 0 ? 0 : nums[0];
        } else if (nums.length == 2) {
            Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i] + dp[i - 2], dp[i - 1]);
        }
        int res = dp[nums.length - 1];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length - 1; ++i) {

        }
        return Math.max(dp[nums.length - 2], res);
    }
}
