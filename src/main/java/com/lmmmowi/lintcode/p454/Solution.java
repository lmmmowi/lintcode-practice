package com.lmmmowi.lintcode.p454;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 454. 矩阵面积[https://www.lintcode.com/problem/454/]
 */
public class Solution {

    class Rectangle {
        private int width;
        private int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getArea() {
            return width * height;
        }
    }
}
