package com.lmmmowi.lintcode.p1496;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 1496. 用Rand7()实现Rand10()[https://www.lintcode.com/problem/1496/]
 */
public class Solution extends SolBase {

//        11,12,13,14
//        15,16,17,21
//        22,23,24,25
//        26,27,31,32
//        33,34,35,36
//        37,41,42,43
//        44,45,46,47
//        51,52,53,54
//        55,56,57,61
//        62,63,64,65
    private static final int[] RANGES = new int[]{
            14, 21, 25, 32, 36, 43, 47, 54, 61, 65
    };

    public int rand10() {
        for (; ; ) {
            int num = rand7() * 10 + rand7();
            for (int i = 0; i < RANGES.length; i++) {
                if (num <= RANGES[i]) {
                    return i;
                }
            }
        }
    }
}
