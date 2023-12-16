package com.whiteknightz.demo.leetCode.hashMapAndSet;

import java.util.ArrayList;
import java.util.List;

/*
    Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are
    equal.

    A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 */
public class EqualRowAndColumnPairs {
    public static int equalPairs(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        List<List<Integer>> rows = new ArrayList<>(row);
        for (int i = 0; i < row; i++) {
            rows.add(new ArrayList<>());
        }
        List<List<Integer>> columns = new ArrayList<>(col);
        for (int i = 0; i < col; i++) {
            columns.add(new ArrayList<>());
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                List<Integer> r = rows.get(i);
                r.add(grid[i][j]);
                rows.set(i, r);

                List<Integer> c = columns.get(j);
                c.add(grid[i][j]);
                columns.set(j, c);
            }
        }

        int matched = 0;

        for (List<Integer> integers : rows) {
            for (List<Integer> column : columns) {
                if (integers.equals(column)) {
                    matched++;
                }
            }
        }

        return matched;
    }

    public static void main(String[] args) {
//        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};

        int result = equalPairs(grid);

        System.out.println("Result:"+result);
    }
}
