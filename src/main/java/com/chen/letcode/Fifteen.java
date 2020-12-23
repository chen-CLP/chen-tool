package com.chen.letcode;


import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2020/12/2 10:17
 * @Version: v1.0
 */
public class Fifteen {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> numsMap = new HashMap<>(nums.length);
        for (int i : nums) {
            int size = numsMap.get(i) == null ? 1 : numsMap.get(i) + 1;
            numsMap.put(i, size);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 3) {
            return resultList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int ii = i + 1; ii < nums.length; ++ii) {
                if (ii > i + 1 && nums[ii] == nums[ii - 1]) {
                    continue;
                }
                int nexNum = 0 - (nums[ii] + nums[i]);
                if (nexNum<nums[ii]){continue;}
                numsMap.put(nums[ii], numsMap.get(nums[ii]) - 1);
                numsMap.put(nums[i], numsMap.get(nums[i]) - 1);
                if (numsMap.get(nexNum) != null && numsMap.get(nexNum) > 0) {
                    List<Integer> tupleList = new ArrayList<>(3);
                    tupleList.add(nums[i]);
                    tupleList.add(nums[ii]);
                    tupleList.add(nexNum);
                    resultList.add(tupleList);
                }
                numsMap.put(nums[ii], numsMap.get(nums[ii]) + 1);
                numsMap.put(nums[i], numsMap.get(nums[i]) + 1);
            }
        }
        return resultList;
    }
}
