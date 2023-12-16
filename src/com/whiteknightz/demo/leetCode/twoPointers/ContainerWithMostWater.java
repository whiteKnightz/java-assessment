package com.whiteknightz.demo.leetCode.twoPointers;

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the
ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container
 */

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while (left<right){
            int h = Math.min(height[left], height[right]);
            int w = right-left;
            int area = h*w;

            maxArea = Math.max(area, maxArea);

            if (height[left]<height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        int result = maxArea(height);

        System.out.println("Result:"+result);
    }
}
