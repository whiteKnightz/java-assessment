package com.whiteknightz.demo.leetCode.slidingWindow;

/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 */

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static int maxVowels(String s, int k) {
        int len = s.length();
        int maxVow = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))){
                maxVow++;
            }
        }

        int currMax = maxVow;

        for (int i = k; i < len; i++) {
            if (isVowel(s.charAt(i-k))){
             currMax--;
            }
            if (isVowel(s.charAt(i))){
                currMax++;
            }
            maxVow = Math.max(currMax, maxVow);
        }

        return maxVow;
    }

    public static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String s = "weallloveyou";
        int k = 7;

        int result = maxVowels(s, k);

        System.out.println("Result:"+result);
        System.out.println("Result correct:"+(result==4));
    }
}
