package com.whiteknightz.demo.leetCode.queue;

/*
    You have a RecentCounter class which counts the number of recent requests within a certain time frame.

    Implement the RecentCounter class:

    RecentCounter() Initializes the counter with zero recent requests.
    int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number
    of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the
    number of requests that have happened in the inclusive range [t - 3000, t].
    It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

 */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {

    private Queue<Integer> requests;

    public NumberOfRecentCalls() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }
        requests.offer(t);

        return requests.size();
    }

    public static void main(String[] args) {
        NumberOfRecentCalls counter = new NumberOfRecentCalls();
        System.out.println(counter.ping(1)); // Returns 1: [1]
        System.out.println(counter.ping(100)); // Returns 2: [1, 100]
        System.out.println(counter.ping(3001)); // Returns 1: [100, 3001]
        System.out.println(counter.ping(3002)); // Returns 2: [3001, 3002]
    }

}
