package binarytrees;

import java.util.ArrayList;
import java.util.List;

public class IsBinarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static boolean checkBST(Node root) {

        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        return isSorted(values);
    }

    private static void inorderTraversal(Node node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, values);
        values.add(node.data);
        inorderTraversal(node.right, values);
    }

    private static boolean isSorted(List<Integer> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) >= values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(8);
        Node node5 = new Node(6);

        node1.left = node2;
        node3.left = node4;
        node3.right = node5;
        node1.right = node3;
        System.out.println(checkBST(node1));
    }
}
