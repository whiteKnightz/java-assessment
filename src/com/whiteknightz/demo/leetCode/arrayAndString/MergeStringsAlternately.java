package com.whiteknightz.demo.leetCode.arrayAndString;

/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with
word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 */
public class MergeStringsAlternately {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();
        int minLen = Math.min(l1, l2);
        for (int i =0; i<minLen;i++){
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(i));
        }

        if (minLen<l1){
            builder.append(word1.substring(minLen));
        }if (minLen<l2){
            builder.append(word2.substring(minLen));
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";

        System.out.println("Result:"+ mergeAlternately(word1, word2));
    }
}
