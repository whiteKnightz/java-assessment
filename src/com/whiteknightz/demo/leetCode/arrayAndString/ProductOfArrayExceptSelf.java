package com.whiteknightz.demo.leetCode.arrayAndString;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.


 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] suf = new int[len];

        pre[0]=1;
        for (int i = 1; i<len; i++){
            pre[i] = pre[i-1]*nums[i-1];
        }

        suf[len-1]=1;
        for (int i = len-2; i>=0; i--){
            suf[i] = suf[i+1]*nums[i+1];
        }

        int[] ans = new int[len];
        for (int i = 0; i<len; i++){
            ans[i]=pre[i]*suf[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        printArray(nums);
        int[] result = productExceptSelf(nums);
        printArray(result);
    }

    public static void printArray(int[] arr){
        System.out.print("\n\nResult:");
        for (int val: arr){
            System.out.print(val+",");
        }
        System.out.print("\n");
    }

}
