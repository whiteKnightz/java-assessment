package com.whiteknightz.demo.codewar;

import java.util.HashMap;
import java.util.Map;

/*
    Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits
    that occur more than once in the input string. The input string can be assumed to contain only alphabets (both
    uppercase and lowercase) and numeric digits.

    Example
    "abcde" -> 0 # no characters repeats more than once
    "aabbcde" -> 2 # 'a' and 'b'
    "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
    "indivisibility" -> 1 # 'i' occurs six times
    "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
    "aA11" -> 2 # 'a' and '1'
    "ABBA" -> 2 # 'A' and 'B' each occur twice
 */
public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c: text.toLowerCase().toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0)+1);
        }
        return (int) charMap.values().stream().filter(integer -> integer > 1).count();
    }

    public static void main(String[] args) {
        System.out.println("No. of duplicate char in 'abcde' must be 0 and is:"+duplicateCount("abcde"));
        System.out.println("No. of duplicate char in 'abcdea' must be 1 and is:"+duplicateCount("abcdea"));
        System.out.println("No. of duplicate char in 'indivisibility' must be 1 and is:"+duplicateCount("indivisibility"));
        System.out.println("No. of duplicate char in 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix' must be 26 and is:"+duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix"));
    }
}
