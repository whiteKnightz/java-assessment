package com.whiteknightz.demo.leetCode.arrayAndString;

/*
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 */

public class GreatestCommonDivisorOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        // Find the GCD of the lengths of str1 and str2
        int gcd = findGCD(len1, len2);

        // Check if the substring of str1 with length gcd divides str1 and str2
        String substring = str1.substring(0, gcd);
        if (str1.equals(repeatString(substring, len1 / gcd)) && str2.equals(repeatString(substring, len2 / gcd))) {
            return substring;
        } else {
            return "";
        }
    }

    // Helper method to find the GCD of two numbers using Euclidean algorithm
    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper method to repeat a string n times
    private static String repeatString(String str, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";

        System.out.println("Result:"+gcdOfStrings(str1, str2));

    }
}
