package matrices;

/**
 * Problem 62. Unique Paths
 * <p>
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or
 * right at any point in time.
 * <p>
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
 * bottom-right corner.
 */
public class FindAllThePaths {

    /**
     * This method finds out all the possible unique ways to get from matrix[0][0] to matrix[m-1[n-1], using
     * dinamic programming.
     *
     * @param matrix a 2D integer array
     * @return all the possible unique ways to get from matrix[0][0] to matrix[m-1[n-1]
     */
    public static int findPaths(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // Create a 2D array to store the number of unique paths to reach each cell
        int[][] dp = new int[m][n];

        // Initialize the first column to 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Initialize the first row to 1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Calculate the number of unique paths for each cell
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The number of unique paths to the bottom-right corner is stored in the last cell of the array
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(findPaths(new int[][]{new int[]{11, 12, 13}, new int[]{21, 22, 23}}));
        System.out.println(findPaths(new int[][]{new int[]{11, 12, 13}, new int[]{21, 22, 23}, new int[]{31, 32, 33}}));
    }
}
