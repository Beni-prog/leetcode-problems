package binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class DuplicateSubtrees {
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> subtreeMap = new HashMap<>();

        // Traverse the tree in a depth-first manner and serialize each subtree
        serializeSubtrees(root, subtreeMap, result);

        return result;
    }

    private static String serializeSubtrees(TreeNode root, Map<String, Integer> subtreeMap, List<TreeNode> result) {
        if (root == null) {
            return "#";
        }

        String left = serializeSubtrees(root.left, subtreeMap, result);
        String right = serializeSubtrees(root.right, subtreeMap, result);

        // Serialize the current subtree
        String subtree = root.val + "," + left + "," + right;

        // Update the subtree map and add the duplicate subtrees to the result
        subtreeMap.put(subtree, subtreeMap.getOrDefault(subtree, 0) + 1);
        if (subtreeMap.get(subtree) == 2) {
            result.add(root);
        }

        return subtree;
    }

    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        List<TreeNode> duplicateNodes = findDuplicateSubtrees(root);

        // Process the duplicateNodes list as per your requirements
        for (TreeNode node : duplicateNodes) {
            System.out.println(node.val);
        }
    }
}
