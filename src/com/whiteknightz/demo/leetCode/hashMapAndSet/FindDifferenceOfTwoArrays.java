package com.whiteknightz.demo.leetCode.hashMapAndSet;

/*
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDifferenceOfTwoArrays {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.asList(
                s1.stream().filter(integer -> !s2.contains(integer)).collect(Collectors.toList()),
                s2.stream().filter(integer -> !s1.contains(integer)).collect(Collectors.toList())
        );
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3}, nums2 = {2,4,6};

        List<List<Integer>> result = findDifference(nums1, nums2);

        for (List<Integer> list: result){
            for (Integer n: list){
                System.out.println(n+",");
            }
            System.out.println("\n");
        }
    }
}
