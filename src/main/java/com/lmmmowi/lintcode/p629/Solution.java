package com.lmmmowi.lintcode.p629;

import java.util.*;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 629. 最小生成树[https://www.lintcode.com/problem/629/]
 */
public class Solution {

    public List<Connection> lowestCost(List<Connection> connections) {
        Map<String, Integer> cities = new HashMap<>();
        int n = 0;
        for (Connection connection : connections) {
            if (!cities.containsKey(connection.city1)) {
                cities.put(connection.city1, n++);
            }
            if (!cities.containsKey(connection.city2)) {
                cities.put(connection.city2, n++);
            }
        }

        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }

        Comparator<Connection> comparator = Comparator.comparingInt((Connection o) -> o.cost)
                .thenComparing((Connection o) -> o.city1)
                .thenComparing((Connection o) -> o.city2);
        connections.sort(comparator);

        List<Connection> result = new ArrayList<>();
        for (Connection connection : connections) {
            int c1 = cities.get(connection.city1);
            int c2 = cities.get(connection.city2);
            if (find(c1, pre) == find(c2, pre)) {
                continue;
            }

            pre[find(c1, pre)] = pre[c2];
            result.add(connection);
        }

        return result.size() == n - 1 ? result : Collections.emptyList();
    }

    private int find(int x, int[] pre) {
        if (x == pre[x]) {
            return x;
        } else {
            return pre[x] = find(pre[x], pre);
        }
    }
}
