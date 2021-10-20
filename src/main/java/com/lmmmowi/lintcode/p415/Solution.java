package com.lmmmowi.lintcode.p415;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/20
 * @Description: 415. 有效回文串[https://www.lintcode.com/problem/415/]
 */
public class Solution {

    public boolean isPalindrome(String s) {
        int len = s.length();
        int head = 0;
        int tail = len - 1;

        while (head < tail) {
            while (head < len && !isValid(s.charAt(head))) {
                head++;
            }

            while (tail >= 0 && !isValid(s.charAt(tail))) {
                tail--;
            }

            if (head < tail) {
                char chead = s.charAt(head);
                char ctail = s.charAt(tail);
                if (toLowerCase(chead) == toLowerCase(ctail)) {
                    head++;
                    tail--;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c >= '0' && c <= '9';
    }

    private char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        } else {
            return c;
        }
    }
}
