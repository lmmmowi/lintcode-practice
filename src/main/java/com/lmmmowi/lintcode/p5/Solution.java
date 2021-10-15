package com.lmmmowi.lintcode.p5;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 5. 第k大元素[https://www.lintcode.com/problem/5]
 */
public class Solution {

    public int kthLargestElement(int k, int[] nums) {
        qsort(k - 1, nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void qsort(int targetIndex, int[] nums, int fromIndex, int toIndex) {
        if (fromIndex >= toIndex) {
            return;
        }

        int low = fromIndex;
        int high = toIndex + 1;
        int pivot = nums[low];

        while (true) {
            while (nums[--high] < pivot && low < high) ;
            if (low < high) {
                nums[low] = nums[high];
            } else {
                break;
            }

            while (nums[++low] >= pivot && low < high) ;
            if (low < high) {
                nums[high] = nums[low];
            } else {
                break;
            }
        }

        nums[low] = pivot;
        if (targetIndex < low) {
            qsort(targetIndex, nums, fromIndex, low - 1);
        } else if (targetIndex > low) {
            qsort(targetIndex, nums, low + 1, toIndex);
        }
    }
}
