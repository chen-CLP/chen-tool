package com.chen.letcode;

import java.math.MathContext;
import java.util.Arrays;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2020/12/2 11:20
 * @Version: v1.0
 */
public class Sixteen {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int maxTarget = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        if (maxTarget <= target) {
            return maxTarget;
        }
        int minTarget = nums[0] + nums[1] + nums[2];
        if (minTarget >= target) {
            return minTarget;
        }
        int result = maxTarget;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right && left > i) {
                int tmp = nums[i] + nums[left] + nums[right];
                result = Math.min(Math.abs(target - tmp), result);
                if (tmp == target) {
                    return tmp;
                } else if (tmp < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
