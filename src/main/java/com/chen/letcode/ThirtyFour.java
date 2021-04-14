package com.chen.letcode;

/**
 * @ClassName: chen-tool
 * @Description: TODO
 * @Author: 陈亮平
 * @Date: 2021/4/14 17:18
 * @Version: v1.0
 */
public class ThirtyFour {
    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;
        int[] res = {-1, -1};
        if (nums[r]==target){res[1]=r;}
        else{
            while (l <= r) {
                mid = (l + r)>>>1;
                if (nums[mid]<target){l=mid+1;}
                else if(nums[mid]>target){r=mid-1;}
                else if(nums[mid]==target&&nums[mid+1]>nums[mid]){res[1]=mid;break;}
                else{
                    l=mid+1;
                }
            }
        }
        l = 0; r = nums.length - 1; mid = 0;
        if (nums[l]==target){res[0]=l;}
        else{
            while (l <= r) {
                mid = (l + r)>>>1;
                if (nums[mid]<target){l=mid+1;}
                else if(nums[mid]>target){r=mid-1;}
                else if(nums[mid]==target&&nums[mid-1]<nums[mid]){res[0]=mid;break;}
                else{
                    r=mid-1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        searchRange(new int[]{5, 7, 7, 8, 8, 10},8);
    }
}
