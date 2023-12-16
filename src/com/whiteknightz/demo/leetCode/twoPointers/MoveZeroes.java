package com.whiteknightz.demo.leetCode.twoPointers;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
 */

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int moved = 0;
        for (int i=0;i<len-moved;i++){
            while (nums[i]==0){
                if (i+moved == len-1){
                    break;
                } else if (nums[i]==0){
                    for (int j=i;j<len-moved-1;j++){
                        nums[j]=nums[j+1];
                    }
                    nums[len-moved-1]=0;
                    moved++;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};
        int[] nums = {0, 0, 1};
        printArray(nums);
        moveZeroes(nums);
        printArray(nums);
    }

    public static void printArray(int[] arr){
        System.out.print("\n\nResult:");
        for (int val: arr){
            System.out.print(val+",");
        }
        System.out.print("\n");
    }
}
