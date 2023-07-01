package recursion;

import binarytrees.LongestZigZagPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateUniqueBST {

    public static List<LongestZigZagPath.TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Arrays.asList(null);
        }

        return generateTrees(1, n);
    }

    private static List<LongestZigZagPath.TreeNode> generateTrees(int start, int end) {
        List<LongestZigZagPath.TreeNode> results = new ArrayList<>();

        if (start > end) {
            results.add(null);
            return results;
        }

        for (int i = start; i <= end; i++) {
            //generate all possible left and right subtrees
            List<LongestZigZagPath.TreeNode> leftTrees = generateTrees(start, i - 1);
            List<LongestZigZagPath.TreeNode> rightTrees = generateTrees(i + 1, end);

            //combine the left subtrees with every right subtree
            for (LongestZigZagPath.TreeNode left : leftTrees) {
                for (LongestZigZagPath.TreeNode right : rightTrees) {
                    LongestZigZagPath.TreeNode root = new LongestZigZagPath.TreeNode(i);
                    root.left = left;
                    root.right = right;
                    results.add(root);
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
}
