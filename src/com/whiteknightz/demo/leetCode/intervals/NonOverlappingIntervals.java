package com.whiteknightz.demo.leetCode.intervals;

import java.util.Arrays;

/*
    Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals
    you need to remove to make the rest of the intervals non-overlapping.
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int nonOverlappingCount = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                nonOverlappingCount++;
                end = intervals[i][1];
            }
        }

        return intervals.length - nonOverlappingCount;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};

        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();

        int result = nonOverlappingIntervals.eraseOverlapIntervals(intervals);
        System.out.println("Result:"+result);
    }
}
