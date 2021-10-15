package com.lmmmowi.lintcode.p363;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 363. 接雨水[https://www.lintcode.com/problem/363/]
 */
public class Solution {

    public int trapRainWater(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], heights[i - 1]);
            right[n - 1 - i] = Math.max(right[n - i], heights[n - i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            int k = Math.min(left[i], right[i]);
            if (k > heights[i]) {
                water += k - heights[i];
            }
        }
        return water;
    }
}
