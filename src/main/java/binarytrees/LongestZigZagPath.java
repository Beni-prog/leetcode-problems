package binarytrees;

/**
 * Problem 1372. Longest ZigZag Path in a Binary Tree
 * <p>
 * You are given the root of a binary tree.
 * <p>
 * A ZigZag path for a binary tree is defined as follow:
 * <p>
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 * Change the direction from right to left or from left to right.
 * Repeat the second and third steps until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 * <p>
 * Return the longest ZigZag path contained in that tree.
 */
public class LongestZigZagPath {

    //Definition for a binary tree node.
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * This method first calls dfs() on the left child of the root, with initial values of 1 for the left parameter and 0
     * for the right parameter. Then it calls dfs() on the right child of the root, with initial values of 0 for the
     * left parameter and 1 for the right parameter. Finally, it returns the maximum value stored in the result array,
     * which represents the length of the longest zigzag path in the entire binary tree.
     *
     * @param root the tree root node
     * @return the maximum zigzag path.
     */
    public static int longestZigZag(LongestZigZagPath.TreeNode root) {
        int[] result = {0};
        dfs(root.left, 1, 0, result);
        dfs(root.right, 0, 1, result);
        return result[0];
    }


    /**
     * The dfs() method keeps track of both the length of the longest left zigzag path and the length of
     * the longest right zigzag path for each node. The left and right parameters represent the length of the current
     * zigzag path in each direction, respectively. The result array is updated accordingly, taking the maximum length of
     * the left and right zigzag paths for each node.
     *
     * @param node   the current node
     * @param left   the longest path for the left direction of the current node
     * @param right  the longest path for the right direction of the current node
     * @param result an array that stores the maximum path
     */
    private static void dfs(LongestZigZagPath.TreeNode node, int left, int right, int[] result) {
        if (node == null) {
            return;
        }
        result[0] = Math.max(result[0], left);
        result[0] = Math.max(result[0], right);
        dfs(node.left, right + 1, 0, result);
        dfs(node.right, 0, left + 1, result);
    }

    public static void main(String[] args) {
        TreeNode leaf1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1, null, leaf1);
        TreeNode node5 = new TreeNode(1, null, node6);
        TreeNode node4 = new TreeNode(1, null, null);
        TreeNode node3 = new TreeNode(1, node5, node4);
        TreeNode node2 = new TreeNode(1, null, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
        TreeNode root = new TreeNode(1, null, node1);
        System.out.println(longestZigZag(root));

        TreeNode leaf2 = new TreeNode(1);
        TreeNode node51 = new TreeNode(1, null, leaf2);
        TreeNode node41 = new TreeNode(1, null, null);
        TreeNode node31 = new TreeNode(1, node51, node41);
        TreeNode node21 = new TreeNode(1, null, node31);
        TreeNode root1 = new TreeNode(1, node21, new TreeNode(1, null, null));
        System.out.println(longestZigZag(root1));
    }
}
