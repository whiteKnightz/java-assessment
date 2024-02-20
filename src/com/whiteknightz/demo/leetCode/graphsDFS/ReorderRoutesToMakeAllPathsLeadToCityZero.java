package com.whiteknightz.demo.leetCode.graphsDFS;

/*
    There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two
    different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in
    one direction because they are too narrow.

    Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

    This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

    Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number
    of edges changed.

    It's guaranteed that each city can reach city 0 after reorder.



    Example 1:


    Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
    Output: 3
    Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
    Example 2:


    Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
    Output: 2
    Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
    Example 3:

    Input: n = 3, connections = [[1,0],[2,0]]
    Output: 0

 */

import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToCityZero {

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] connection : connections) {
            graph.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
            graph.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(-connection[0]);
        }
        return dfs(0, -1, graph, new boolean[n]);
    }

    private int dfs(int current, int parent, Map<Integer, List<Integer>> graph, boolean[] visited) {
        visited[current] = true;
        int changed = 0;
        for (int neighbor: graph.getOrDefault(current, Collections.emptyList())) {
            if (!visited[Math.abs(neighbor)]){
                changed += dfs(Math.abs(neighbor), current, graph, visited) + (neighbor > 0 ? 1 : 0);
            }
        }
        return changed;
    }

    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathsLeadToCityZero routes = new ReorderRoutesToMakeAllPathsLeadToCityZero();

        int n1 = 6;
        int[][] connections1 = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println("The value is supposed to be 3 and is: "+routes.minReorder(n1, connections1));

        int n2 = 5;
        int[][] connections2 = {{1,0},{1,2},{3,2},{3,4}};
        System.out.println("The value is supposed to be 2 and is: "+routes.minReorder(n2, connections2));

        int n3 = 3;
        int[][] connections3 = {{1,0},{2,0}};
        System.out.println("The value is supposed to be 0 and is: "+routes.minReorder(n3, connections3));
    }
}
