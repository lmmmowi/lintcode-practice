package com.lmmmowi.lintcode.p148;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/20
 * @Description: 148. 颜色分类[https://www.lintcode.com/problem/148/]
 */
public class Solution {

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = 2;
            if (num < 2) {
                nums[p1++] = 1;
                if (num == 0) {
                    nums[p0++] = 0;
                }
            }
        }
    }
}
