package recursion;

import binarytrees.LongestZigZagPath;

public class MaxDepthBinaryTree {
    public static int maxDepth(LongestZigZagPath.TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        LongestZigZagPath.TreeNode leaf1 = new LongestZigZagPath.TreeNode(1);
        LongestZigZagPath.TreeNode node6 = new LongestZigZagPath.TreeNode(1, null, leaf1);
        LongestZigZagPath.TreeNode node5 = new LongestZigZagPath.TreeNode(1, null, node6);
        LongestZigZagPath.TreeNode node4 = new LongestZigZagPath.TreeNode(1, null, null);
        LongestZigZagPath.TreeNode node3 = new LongestZigZagPath.TreeNode(1, node5, node4);
        LongestZigZagPath.TreeNode node2 = new LongestZigZagPath.TreeNode(1, null, null);
        LongestZigZagPath.TreeNode node1 = new LongestZigZagPath.TreeNode(1, node2, node3);
        LongestZigZagPath.TreeNode root = new LongestZigZagPath.TreeNode(1, null, node1);
        System.out.println(maxDepth(root));//6
    }
}
