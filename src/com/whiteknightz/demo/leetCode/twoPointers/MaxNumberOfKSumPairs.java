package com.whiteknightz.demo.leetCode.twoPointers;

/*
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.
 */

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> feqMap = new HashMap<>();
        for (int n: nums){
            feqMap.put(n, feqMap.getOrDefault(n, 0)+1);
        }

        int op = 0;

        for (int n: nums){
            if (n<k){
                int comp = Math.abs(k-n);

                if (comp!=0 && feqMap.containsKey(comp) && ((n==comp && feqMap.get(comp)>1) || (n!=comp && feqMap.get(n)>0 && feqMap.get(comp)>0))){
                    op++;
                    feqMap.put(comp, feqMap.get(comp)-1);
                    feqMap.put(n, feqMap.get(n)-1);
                }
            }
        }

            return op;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4};
//        int[] nums = {3,1,3,4,3};
        int[] nums = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 3;
        int result = maxOperations(nums, k);
        System.out.println("Result:"+result);
    }
}
