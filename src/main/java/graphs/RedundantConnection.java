package graphs;

import java.util.Arrays;

public class RedundantConnection {

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        // Initialize parent array
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Traverse the edges and perform union operation
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Find the parent of u and v
            int parentU = findParent(parent, u);
            int parentV = findParent(parent, v);

            // If the parents are the same, it means there is a cycle
            // Return the current edge
            if (parentU == parentV) {
                return edge;
            }

            // Perform union by updating the parent of parentV
            parent[parentV] = parentU;
        }

        return new int[]{-1}; // No redundant edge found
    }

    private static int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));//[2, 3]
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));//[1, 4]
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4, 5}})));//[1, 3]
    }
}
