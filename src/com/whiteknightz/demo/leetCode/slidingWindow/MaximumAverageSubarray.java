package com.whiteknightz.demo.leetCode.slidingWindow;

/*
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
Any answer with a calculation error less than 10-5 will be accepted.

 */

public class MaximumAverageSubarray {
    public static double findMaxAverage(int[] nums, int k) {

        int sum =0;
        for (int i = 0; i <k; i++) {
            sum+=nums[i];
        }

        double maxAvg = (double) sum/k;

        for (int i = k; i < nums.length; i++) {
            sum+=nums[i]-nums[i-k];

            double currAvg = (double) sum/k;

            maxAvg = Math.max(currAvg, maxAvg);
        }

        return maxAvg;
    }

    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;

        double result = findMaxAverage(nums, k);

        System.out.println("Result:"+result);
    }
}
