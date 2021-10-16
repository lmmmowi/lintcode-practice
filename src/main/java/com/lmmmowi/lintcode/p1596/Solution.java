package com.lmmmowi.lintcode.p1596;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 1596. 可能的二分法[https://www.lintcode.com/problem/1596/]
 */
public class Solution {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        UnionFind group = new UnionFind(N);
        int[] dislikeRef = new int[N + 1];

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            int pa = group.find(a);
            int pb = group.find(b);
            if (pa > 0 && pa == pb) {
                return false;
            }

            if (dislikeRef[a] > 0) {
                group.union(dislikeRef[a], b);
            } else {
                dislikeRef[a] = b;
            }

            if (dislikeRef[b] > 0) {
                group.union(dislikeRef[b], a);
            } else {
                dislikeRef[b] = a;
            }
        }

        return true;
    }

    private class UnionFind {
        private int[] pre;

        public UnionFind(int n) {
            pre = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pre[i] = i;
            }
        }

        private int find(int x) {
            if (x == pre[x]) {
                return x;
            } else {
                return pre[x] = find(pre[x]);
            }
        }

        private void union(int x, int y) {
            pre[find(x)] = find(y);
        }
    }
}
