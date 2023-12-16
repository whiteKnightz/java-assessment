package com.whiteknightz.demo.leetCode.monotonicStack;

import java.util.Stack;

/*
    Given an array of integers temperatures represents the daily temperatures, return an array answer such that
    answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no
    future day for which this is possible, keep answer[i] == 0 instead.
 */

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] daysSpent = new int[len];
        Stack<Integer> temps = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!temps.isEmpty() && temperatures[i]>temperatures[temps.peek()]){
                int prevIndex = temps.pop();
                daysSpent[prevIndex] = i-prevIndex;
            }
            temps.push(i);
        }

        return daysSpent;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(temperatures);
        System.out.println("result:");
        for(int i: result){
            System.out.println(i);
        }
    }
}
