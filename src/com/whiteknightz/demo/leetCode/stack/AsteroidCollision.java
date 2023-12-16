package com.whiteknightz.demo.leetCode.stack;

/*
    We are given an array asteroids of integers representing asteroids in a row.

    For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning
    right, negative meaning left). Each asteroid moves at the same speed.

    Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If
    both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 */

import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> values = new Stack<>();
        for (int asteroid: asteroids){
            if (values.isEmpty()){
                values.push(asteroid);
            } else {
                handleCollision(values, asteroid);
            }
        }

        int[] result = new int[values.size()];
        for (int i = result.length-1; i >=0; i--) {
            result[i] = values.pop();
        }
        return result;
    }

    private static void handleCollision(Stack<Integer> asteroids, int asteroid) {
        while (!asteroids.isEmpty() && asteroids.peek()>0 && asteroid<0){
            Integer popVal = asteroids.pop();
            if (popVal==-asteroid){
                return;
            }
            if (popVal>-asteroid){
                asteroids.push(popVal);
                return;
            }
        }
        asteroids.push(asteroid);

    }

    public static void main(String[] args) {
//        int[] asteroids = {5,10,-5};
        int[] asteroids = {-2,-1,1,2};
        int[] result = asteroidCollision(asteroids);
        System.out.println("Result:");
        for (int i: result){
            System.out.println(i);
        }
    }
}
