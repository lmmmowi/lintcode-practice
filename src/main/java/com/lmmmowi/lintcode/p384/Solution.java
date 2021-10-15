package com.lmmmowi.lintcode.p384;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 384. 最长无重复字符的子串[https://www.lintcode.com/problem/384/]
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        boolean[] exists = new boolean[256];
        int n = s.length();
        int slow = 0;
        int fast = -1;
        int longest = 0;

        while (slow < n) {
            while (fast + 1 < n) {
                char c = s.charAt(fast + 1);
                if (exists[(int) c]) {
                    break;
                } else {
                    exists[(int) c] = true;
                    fast++;
                }
            }

            longest = Math.max(longest, fast - slow + 1);
            char c = s.charAt(slow++);
            exists[(int) c] = false;
        }

        return longest;
    }
}
