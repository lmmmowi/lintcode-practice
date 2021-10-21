package com.lmmmowi.lintcode.p184;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 184. 最大数[https://www.lintcode.com/problem/184/]
 */
public class Solution {

    public String largestNumber(int[] nums) {
        String result = Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining());
        return result.startsWith("0") ? "0" : result;
    }
}
