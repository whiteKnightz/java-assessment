package com.whiteknightz.demo.leetCode.bitManipulation;

/*
    Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of
    1's in the binary representation of i.
 */

public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int init =i;
            int count = 0;
            while(init>0){
                count += init & 1;
                init = init>>1;
            }
            result[i]=count;
        }

        return result;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int n=5;
        int[] result = countingBits.countBits(n);

        System.out.println("Result:");
        for (int i: result){
            System.out.println(i);
        }
    }
}
