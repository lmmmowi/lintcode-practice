package com.lmmmowi.lintcode.p1506;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lmmmowi
 * @Date: 2021/10/15
 * @Description: 1506. 二叉树中所有距离为 K 的结点[https://www.lintcode.com/problem/1506/]
 */
public class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        findParent(root, parentMap);

        List<Integer> result = new ArrayList<>();
        TreeNode node = target;
        TreeNode prev = null;

        for (int i = 0; i <= K; i++) {
            findChildrenWithDistanceK(node, K - i, prev, result);

            prev = node;
            node = parentMap.get(node);
            if (node == null) {
                break;
            }
        }

        return result;
    }

    private void findParent(TreeNode node, Map<TreeNode, TreeNode> parentMap) {
        if (node.left != null) {
            parentMap.put(node.left, node);
            findParent(node.left, parentMap);
        }

        if (node.right != null) {
            parentMap.put(node.right, node);
            findParent(node.right, parentMap);
        }
    }

    private void findChildrenWithDistanceK(TreeNode node, int k, TreeNode ignore, List<Integer> result) {
        if (k == 0) {
            result.add(node.val);
            return;
        }

        if (node.left != null && node.left != ignore) {
            findChildrenWithDistanceK(node.left, k - 1, ignore, result);
        }

        if (node.right != null && node.right != ignore) {
            findChildrenWithDistanceK(node.right, k - 1, ignore, result);
        }
    }
}
