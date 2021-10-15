package com.lmmmowi.lintcode.p364;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 364. 接雨水 II[https://www.lintcode.com/problem/364/]
 */
public class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
            new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0}
    };

    public int trapRainWater(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> heights[o[0]][o[1]]));
        boolean[][] marked = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            mark(priorityQueue, marked, i, 0);
            mark(priorityQueue, marked, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            mark(priorityQueue, marked, 0, i);
            mark(priorityQueue, marked, n - 1, i);
        }

        int water = 0;
        while (!priorityQueue.isEmpty()) {
            int[] point = priorityQueue.poll();
            int x = point[0];
            int y = point[1];

            for (int[] direction : DIRECTIONS) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !marked[nx][ny]) {
                    if (heights[x][y] > heights[nx][ny]) {
                        water += Math.max(heights[x][y] - heights[nx][ny], 0);
                        heights[nx][ny] = heights[x][y];
                    }
                    mark(priorityQueue, marked, nx, ny);
                }
            }
        }

        return water;
    }

    private void mark(PriorityQueue<int[]> priorityQueue, boolean[][] marked, int x, int y) {
        if (!marked[x][y]) {
            marked[x][y] = true;
            priorityQueue.add(new int[]{x, y});
        }
    }
}
