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

    /*
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        
        // Loop until all bits of a, b, and c have been processed
        while (a > 0 || b > 0 || c > 0) {
            // Extract the rightmost bit of each number using bitwise AND with 1
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;
            
            if (bitC == 0) {
                // If target is 0, any 1s in bitA or bitB must be flipped to 0
                flips += (bitA + bitB);
            } else {
                // If target is 1, at least one of bitA or bitB must be 1
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            }
            
            // Shift right by 1 to move to the next bit position
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        
        return flips;
    }
    */

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
