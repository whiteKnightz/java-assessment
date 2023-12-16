package com.whiteknightz.demo.leetCode.hashMapAndSet;

/*
    Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or
    false otherwise.

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int n: arr){
            numMap.put(n, numMap.getOrDefault(n,0)+1);
        }
        Set<Integer> uniqValues = numMap.values().stream().collect(Collectors.toSet());
        return uniqValues.size()== numMap.size();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};

        boolean result = uniqueOccurrences(arr);

        System.out.println("Result:"+result);
    }
}
