package com.whiteknightz.demo.leetCode.hashMapAndSet;

/*
    Two strings are considered close if you can attain one from the other using the following operations:

    Operation 1: Swap any two existing characters.
    For example, abcde -> aecdb
    Operation 2: Transform every occurrence of one existing character into another existing character, and do the same
    with the other character.
    For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
    You can use the operations on either string as many times as necessary.

    Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DetermineIfTwoStringsAreClose {
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length()!=word2.length()){
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char c: word1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        for (char c: word2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }
        if (!map1.keySet().equals(map2.keySet())){
            return false;
        }
        return map1.values().stream().sorted().collect(Collectors.toList()).equals(map2.values().stream().sorted().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        String word1 = "cabbba", word2 = "abbccc";

        boolean result = closeStrings(word1, word2);

        System.out.println("Result:"+result);
    }
}
