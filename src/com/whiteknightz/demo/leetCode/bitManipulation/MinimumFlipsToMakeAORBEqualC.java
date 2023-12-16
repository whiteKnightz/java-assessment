package com.whiteknightz.demo.leetCode.bitManipulation;

/*
    Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make
    ( a OR b == c ). (bitwise OR operation).
    Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.



    Example 1:



    Input: a = 2, b = 6, c = 5
    Output: 3
    Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
    Example 2:

    Input: a = 4, b = 2, c = 7
    Output: 1
    Example 3:

    Input: a = 1, b = 2, c = 3
    Output: 0

 */

public class MinimumFlipsToMakeAORBEqualC {

    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;


            if ((bitA | bitB) != bitC) {
                if (bitC == 1) {
                    flips += 1;
                } else {
                    flips += bitA + bitB;
                }
            }
        }

        return flips;
    }

    public static void main(String[] args) {
//        int a = 2, b = 6, c = 5;
//        int a = 4, b = 2, c = 7;
//        int a = 1, b = 2, c = 3;
        int a = 8, b = 3, c = 5;

        MinimumFlipsToMakeAORBEqualC flips = new MinimumFlipsToMakeAORBEqualC();

        int result = flips.minFlips(a, b, c);
        System.out.println("Result:"+result);
    }
}
