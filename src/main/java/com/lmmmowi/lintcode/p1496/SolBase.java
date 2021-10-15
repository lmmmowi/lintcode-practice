package com.lmmmowi.lintcode.p1496;

import java.util.Random;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description:
 */
class SolBase {

    private final Random random = new Random(System.currentTimeMillis());

    protected int rand7() {
        return random.nextInt(7) + 1;
    }
}
