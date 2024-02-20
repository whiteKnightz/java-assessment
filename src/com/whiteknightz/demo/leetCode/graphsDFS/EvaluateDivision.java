package com.whiteknightz.demo.leetCode.graphsDFS;

/*
    You are given an array of variable pairs equations and an array of real numbers values, where
    equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that
    represents a single variable.

    You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the
    answer for Cj / Dj = ?.

    Return the answers to all queries. If a single answer cannot be determined, return -1.0.

    Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and
    that there is no contradiction.

    Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined
    for them.



    Example 1:

    Input: equations = [["a","b"],["b","c"]]
    values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]

    Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
    Explanation:
    Given: a / b = 2.0, b / c = 3.0
    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
    return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
    note: x is undefined => -1.0
    Example 2:

    Input: equations = [["a","b"],["b","c"],["bc","cd"]],
    values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
    Output: [3.75000,0.40000,5.00000,0.20000]
    Example 3:

    Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
    Output: [0.50000,2.00000,-1.00000,-1.00000]
 */

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            Set<String> visited = new HashSet<>();
            results[i] = dfs(graph, start, end, visited);
        }

        return results;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());

            graph.get(from).put(to, value);
            graph.get(to).put(from, 1.0 / value);
        }

        return graph;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (!graph.containsKey(start) || !graph.containsKey(end))
            return -1.0;
        if (start.equals(end))
            return 1.0;

        visited.add(start);
        for (String neighbor : graph.get(start).keySet()) {
            if (!visited.contains(neighbor)) {
                double result = dfs(graph, neighbor, end, visited);
                if (result != -1.0) {
                    return result * graph.get(start).get(neighbor);
                }
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision division = new EvaluateDivision();
    }
}
