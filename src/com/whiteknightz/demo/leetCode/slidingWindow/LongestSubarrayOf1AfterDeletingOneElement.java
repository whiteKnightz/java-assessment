package com.whiteknightz.demo.leetCode.slidingWindow;

/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 */

public class LongestSubarrayOf1AfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        int zeroCount = 0, maxCon1 = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right]==0){
                zeroCount++;
            }
            while (zeroCount>1){
                if (nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            maxCon1 = Math.max(maxCon1, right-left+1);
        }

        return maxCon1-1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1, 1, 0, 0, 1};
        int result = longestSubarray(nums);

        System.out.println("Result:"+result);
    }
}
