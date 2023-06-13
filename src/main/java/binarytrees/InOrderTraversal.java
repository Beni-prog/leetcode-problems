package binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> integers = new ArrayList<>();

        if (root == null) {
            return integers;
        }

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node of the current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Visit the current node (the root) and move to its right subtree
            current = stack.pop();
            integers.add(current.val);
            current = current.right;
        }

        return integers;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, null, node4);
        TreeNode node2 = new TreeNode(2, node3, null);
        TreeNode node1 = new TreeNode(1, null, node2);

        System.out.println(inorderTraversal(node1));//1, 3, 4, 2
    }
}
