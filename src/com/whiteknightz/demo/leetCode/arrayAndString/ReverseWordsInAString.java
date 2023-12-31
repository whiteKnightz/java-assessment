package com.whiteknightz.demo.leetCode.arrayAndString;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should
only have a single space separating the words. Do not include any extra spaces.


 */
public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String[] s1 = s.split(" +");
        for (String val:s1){
            builder.insert(0, " ").insert(0, val);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";

        String result = reverseWords(s);

        System.out.println("Result should be 'example good a':"+result);
    }
}
