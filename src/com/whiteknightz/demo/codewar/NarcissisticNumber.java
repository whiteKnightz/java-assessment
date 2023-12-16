package com.whiteknightz.demo.codewar;

/*
    A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits, each raised to
    the power of the number of digits in a given base. In this Kata, we will restrict ourselves to decimal (base 10).

    For example, take 153 (3 digits), which is narcissistic:

        1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
    and 1652 (4 digits), which isn't:

        1^4 + 6^4 + 5^4 + 2^4 = 1 + 1296 + 625 + 16 = 1938
 */

public class NarcissisticNumber {
    public static boolean isNarcissistic(int number) {
        char[] chars = String.valueOf(number).toCharArray();
        int len = chars.length;
        int sum=0;
        for (char c: chars){
            sum += Math.pow(Integer.parseInt(String.valueOf(c)), len);
        }
        return sum==number;
    }

    public static void main(String[] args) {
        System.out.println("153 is narcissistic:"+isNarcissistic(153));;
        System.out.println("1652 is narcissistic:"+isNarcissistic(1652));;
        System.out.println("1634 is narcissistic:"+isNarcissistic(1634));;
        System.out.println("112 is narcissistic:"+isNarcissistic(112));;
    }
}
