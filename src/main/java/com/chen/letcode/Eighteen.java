package com.chen.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: chen-tool
 * @Description: 四数之和
 * @Author: 陈亮平
 * @Date: 2020/12/21 23:09
 * @Version: v1.0
 */
public class Eighteen {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < len - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int ii = i + 1; ii < len - 2; ++ii) {
                if (ii > i + 1 && nums[ii] == nums[ii - 1]) {
                    continue;
                }
                int right = len - 1;
                int left = ii + 1;
                while (left < right) {
                    int tem = nums[left] + nums[right] + nums[i] + nums[ii];
                    if (tem > target) {
                        right--;
                    } else if (tem < target) {
                        left++;
                    } else {
                        List<Integer> temList = new ArrayList<>();
                        temList.add(nums[i]);
                        temList.add(nums[ii]);
                        temList.add(nums[left]);
                        temList.add(nums[right]);
                        resultList.add(temList);
                        for (left++; left < right && nums[left] == nums[left - 1]; ++left) {
                        }
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<List<Integer>> resultList = fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
        System.out.println("resultList = " + resultList.size());
    }
}
