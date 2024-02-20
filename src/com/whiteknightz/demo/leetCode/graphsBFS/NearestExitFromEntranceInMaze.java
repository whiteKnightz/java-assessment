package com.whiteknightz.demo.leetCode.graphsBFS;

import java.util.LinkedList;
import java.util.Queue;

/*
    You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
    You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column
    of the cell you are initially standing at.

    In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot
    step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell
    that is at the border of the maze. The entrance does not count as an exit.

    Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.



    Example 1:


    Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
    Output: 1
    Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
    Initially, you are at the entrance cell [1,2].
    - You can reach [1,0] by moving 2 steps left.
    - You can reach [0,2] by moving 1 step up.
    It is impossible to reach [2,3] from the entrance.
    Thus, the nearest exit is [0,2], which is 1 step away.
    Example 2:


    Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
    Output: 2
    Explanation: There is 1 exit in this maze at [1,2].
    [1,0] does not count as an exit since it is the entrance cell.
    Initially, you are at the entrance cell [1,0].
    - You can reach [1,2] by moving 2 steps right.
    Thus, the nearest exit is [1,2], which is 2 steps away.
    Example 3:


    Input: maze = [[".","+"]], entrance = [0,0]
    Output: -1
    Explanation: There are no exits in this maze.

 */
public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int step = poll[2];

            if ((x != entrance[0] || y != entrance[1]) && (x == 0 || x == m - 1 || y == 0 || y == n - 1)) {
                return step;
            }
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == '.') {
                    maze[newX][newY] = '+';
                    queue.offer(new int[]{newX, newY, step + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NearestExitFromEntranceInMaze maze = new NearestExitFromEntranceInMaze();

        char[][] mazeVal1 = {{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}};
        int[] entrance1 = {1, 2};
        System.out.println("The expected value is 1 and is: " + maze.nearestExit(mazeVal1, entrance1));

        char[][] mazeVal2 = {{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}};
        int[] entrance2 = {1, 0};
        System.out.println("The expected value is 2 and is: " + maze.nearestExit(mazeVal2, entrance2));

        char[][] mazeVal3 = {{'.', '+'}};
        int[] entrance3 = {0, 0};
        System.out.println("The expected value is -1 and is: " + maze.nearestExit(mazeVal3, entrance3));

        char[][] mazeVal = {{'.'}, {'.'}, {'.'}, {'.'}};
        int[] entrance = {2, 0};
        System.out.println("The expected value is 1 and is: " + maze.nearestExit(mazeVal, entrance));

    }
}
