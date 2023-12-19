package com.whiteknightz.demo.codewar;

/*
    Given two integers a and b, which can be positive or negative, find the sum of all the integers between and
    including them and return it. If the two numbers are equal return a or b.

    Note: a and b are not ordered!

    Examples (a, b) --> output (explanation)
    (1, 0) --> 1 (1 + 0 = 1)
    (1, 2) --> 3 (1 + 2 = 3)
    (0, 1) --> 1 (0 + 1 = 1)
    (1, 1) --> 1 (1 since both are same)
    (-1, 0) --> -1 (-1 + 0 = -1)
    (-1, 2) --> 2 (-1 + 0 + 1 + 2 = 2)
    Your function should only return a number, not the explanation about how you get that number.
 */
public class BeginnerSeriesSumOfNumbers {
    public int GetSum(int a, int b)
    {
        if (a==b){
            return a;
        }
        int lowerVal = Math.min(a, b);
        int upperVal = Math.max(a, b);
        int sum = 0;
        for (int i = lowerVal; i <=upperVal; i++) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Result is supposed to be HEY JUDE\n");
    }
}
