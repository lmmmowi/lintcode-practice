package com.lmmmowi.lintcode.p54;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/20
 * @Description: 54. 转换字符串到整数[https://www.lintcode.com/problem/54/]
 */
public class Solution {

    public int atoi(String s) {
        s = format(s);
        boolean isNegative = false;
        if (s.length() > 0) {
            char fc = s.charAt(0);
            if (fc == '+' || fc == '-') {
                isNegative = fc == '-';
                s = s.substring(1);
            }
        }

        if (s.length() == 0) {
            return 0;
        }

        boolean overLimit;
        String max = String.valueOf(Integer.MAX_VALUE);
        if (s.length() > max.length()) {
            overLimit = true;
        } else if (s.length() < max.length()) {
            overLimit = false;
        } else {
            overLimit = max.compareTo(s) < 0;
        }

        if (isNegative) {
            return overLimit ? Integer.MIN_VALUE : -Integer.parseInt(s);
        } else {
            return overLimit ? Integer.MAX_VALUE : Integer.parseInt(s);
        }
    }

    private String format(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                boolean isSignal = c == '+' || c == '-';
                boolean isNumber = c >= '0' && c <= '9';
                if (isNumber || (isSignal && sb.length() == 0)) {
                    sb.append(c);
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
