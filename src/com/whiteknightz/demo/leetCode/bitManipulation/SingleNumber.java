package com.whiteknightz.demo.leetCode.bitManipulation;

/*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int n: nums){
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }

        return freqMap.entrySet().stream().filter(integerIntegerEntry -> integerIntegerEntry.getValue()==1).collect(Collectors.toList()).get(0).getKey();
    }

    public static void main(String[] args) {
//        int[] nums = {2,2,1};
        int[] nums = {4,1,2,1,2};
        SingleNumber singleNumber = new SingleNumber();
        int result = singleNumber.singleNumber(nums);
        System.out.println("Result:"+result);
    }
}
