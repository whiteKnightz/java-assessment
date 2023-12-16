package com.whiteknightz.demo.leetCode.arrayAndString;

import java.util.ArrayList;
import java.util.List;

/*
There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of
candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
they will have the greatest number of candies among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.


 */
public class KidGreatCandiesCount {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int len = candies.length;
            List<Boolean> result = new ArrayList<>(len);
            int max = Integer.MIN_VALUE;
            for (int val: candies){
                if (val>max){
                    max=val;
                }
            }

            for (int i=0;i<len;i++){
                result.add(i,(candies[i]+extraCandies)>=max);
            }

            return result;
    }

    public static void main(String[] args) {
        int [] candies = new int[]{2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> result = kidsWithCandies(candies, extraCandies);

        System.out.println("Result:");
        for(int i=0;i<candies.length;i++){
            System.out.println(candies[i]+", "+result.get(i));
        }
    }
}
