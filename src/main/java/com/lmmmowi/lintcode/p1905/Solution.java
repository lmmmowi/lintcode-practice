package com.lmmmowi.lintcode.p1905;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/20
 * @Description: 1095. 最大的交换[https://www.lintcode.com/problem/1095/]
 */
public class Solution {

    public int maximumSwap(int num) {
        StringBuilder numStr = new StringBuilder().append(num);
        int len = numStr.length();
        for (int i = 0; i < len; i++) {
            char ci = numStr.charAt(i);
            char cm = ci;
            int maxIndex = -1;
            for (int j = len - 1; j > i; j--) {
                char cj = numStr.charAt(j);
                if (cj > cm) {
                    cm = cj;
                    maxIndex = j;
                }
            }

            if (maxIndex > -1) {
                numStr.setCharAt(i, cm);
                numStr.setCharAt(maxIndex, ci);
                break;
            }
        }
        return Integer.parseInt(numStr.toString());
    }
}
