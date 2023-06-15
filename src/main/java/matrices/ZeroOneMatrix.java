package matrices;

import utils.Utils;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public static int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();

        //start doing BFS from 0 cells and increment by 1 each of its neighbor
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    //mark this cell as visited
                    mat[i][j] = -1;
                }
            }
        }

        int[][] directions = new int[][]{{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        int neighborsOfZeroLevel = 0;

        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            neighborsOfZeroLevel++;

            while (queueSize > 0) {
                int[] zeroCellIndices = queue.poll();
                for (int[] direction : directions) {
                    int row = zeroCellIndices[0] + direction[0];
                    int column = zeroCellIndices[1] + direction[1];

                    if (row < 0 || column < 0 || row >= mat.length || column >= mat[0].length || mat[row][column] != -1) {
                        continue;
                    }

                    mat[row][column] = neighborsOfZeroLevel;
                    queue.add(new int[]{row, column});
                }
                queueSize--;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Utils.displayMatrix(updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
    }
}
