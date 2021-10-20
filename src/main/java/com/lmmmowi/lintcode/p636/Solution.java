package com.lmmmowi.lintcode.p636;

import java.util.Stack;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/20
 * @Description: 636. 132 模式[https://www.lintcode.com/problem/636/]
 */
public class Solution {

    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int last = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (num < last) {
                return true;
            }

            while (!stack.isEmpty() && num > stack.peek()) {
                last = stack.pop();
            }
            stack.push(num);
        }
        return false;
    }
}
