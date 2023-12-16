package com.whiteknightz.demo.leetCode.slidingWindow;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip
at most k 0's.
 */

public class MaxConsecutiveOnes {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, zeroCount = 0, maxConItem = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right]==0){
                zeroCount++;
            }

            while (zeroCount>k){
                if (nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            maxConItem = Math.max(maxConItem, right-left+1);
        }
        return maxConItem;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        int result = longestOnes(nums, k);

        System.out.println("Result:"+result);
    }
}
