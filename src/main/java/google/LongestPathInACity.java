package google;

import java.util.LinkedList;
import java.util.Queue;

public class LongestPathInACity {

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int findLongestPath(int[][] matrix) {
        int longestPath = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int pathLength = bfs(i, j, matrix);
                    longestPath = Math.max(longestPath, pathLength);
                }
            }
        }

        return longestPath;
    }

    private static int bfs(int row, int column, int[][] matrix) {

        Queue<int[]> queue = new LinkedList<>();
        int pathLength = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;

        queue.offer(new int[]{row, column});

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int iCell = cell[0];
                int jCell = cell[1];

                for (int[] dir : DIRECTIONS) {
                    int newICell = iCell + dir[0];
                    int newJCell = jCell + dir[1];

                    if (newICell >= 0 && newICell < rows && newJCell >= 0 && newJCell < columns && matrix[newICell][newJCell] == 1) {
                        matrix[newICell][newJCell] = matrix[iCell][jCell] + 1; // Update the distance
                        queue.offer(new int[]{newICell, newJCell});
                        pathLength = matrix[newICell][newJCell]; // Update the path length
                    }
                }
            }
        }

        return pathLength;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0}
        };

        int longestPath = findLongestPath(matrix);
        System.out.println("Longest path length: " + longestPath);
    }
}
