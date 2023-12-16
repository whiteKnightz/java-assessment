package com.whiteknightz.demo.leetCode.prefixSum;

/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of
all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This
also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
 */

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        int leftSum = 0, totalSum = 0;
        for(int n: nums){
            totalSum += n;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum==totalSum-leftSum-nums[i]){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        int result = pivotIndex(nums);
        System.out.println("Result:"+result);
    }
}
