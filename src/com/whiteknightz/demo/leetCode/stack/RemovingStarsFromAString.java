package com.whiteknightz.demo.leetCode.stack;

/*
    You are given a string s, which contains stars *.

    In one operation, you can:

    Choose a star in s.
    Remove the closest non-star character to its left, as well as remove the star itself.
    Return the string after all stars have been removed.

    Note:

    The input will be generated such that the operation is always possible.
    It can be shown that the resulting string will always be unique.
 */

import java.util.Stack;

public class RemovingStarsFromAString {
    public static String removeStars(String s) {
        int len = s.length();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c=='*'){
                characters.pop();
            } else {
                characters.push(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!characters.isEmpty()){
            builder.insert(0, characters.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        String result = removeStars(s);
        System.out.println("Result:"+result);
    }
}
