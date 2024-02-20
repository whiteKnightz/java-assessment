package com.whiteknightz.demo.leetCode.graphsDFS;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are
 * directly connected, and isConnected[i][j] = 0 otherwise.
 **/
public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int provinces = 0;

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;
        for (int nextCity = 0; nextCity < isConnected.length; nextCity++) {
            if (isConnected[city][nextCity] == 1 && !visited[nextCity]) {
                dfs(isConnected, visited, nextCity);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println("The number of connected city must be 2 and is: " + findCircleNum(isConnected1));

        int[][] isConnected2 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println("The number of connected city must be 3 and is: " + findCircleNum(isConnected2));
    }
}
