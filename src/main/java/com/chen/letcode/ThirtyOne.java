package com.chen.letcode;

import java.nio.file.OpenOption;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/2/5 11:26
 * @Version: v1.0
 */
public class ThirtyOne {
    public static void nextPermutation(int[] nums) {
        Integer max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] < max) {
                int next = i;
                for (int j = i + 1; j < nums.length; ++j) {
                    if (nums[i] < nums[j] && (next == i || nums[next] > nums[j])) {
                        next = j;
                    }
                }
                nums[i] = nums[next] + nums[i];
                nums[next] = nums[i] - nums[next];
                nums[i] = nums[i] - nums[next];
                for (int j = i + 1; j < nums.length; ++j) {
                    next = j;
                    for (int li = j + 1; li < nums.length; ++li) {
                        if (nums[li] < nums[next]) {
                            next = li;
                        }
                    }
                    if (j == next) {
                        continue;
                    }
                    nums[j] = nums[next] + nums[j];
                    nums[next] = nums[j] - nums[next];
                    nums[j] = nums[j] - nums[next];
                }
                return;
            }
            max = Math.max(max, nums[i]);
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        String email="d228369751@qq.com";
        System.out.println(email.matches("(^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$)"));
    }
}
