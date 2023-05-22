package google;

import utils.Utils;

public class KnightsTour {
    private static final int BOARD_SIZE = 8; // Size of the chessboard
    private static final int[] ROW_MOVES = {-2, -1, 1, 2, 2, 1, -1, -2}; // Possible row moves for the knight: -2 means 2 rows up
    private static final int[] COL_MOVES = {1, 2, 2, 1, -1, -2, -2, -1}; // Possible column moves for the knight: -1 means 1 column left

    // Function to solve the Knight's Tour problem using backtracking
    private static boolean solveKnightsTour(int[][] board, int row, int col, int moveCount) {
        if (moveCount == BOARD_SIZE * BOARD_SIZE + 1) {
            return true; // Base case: All squares have been visited
        }

        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != 0) {
            return false; // Invalid move or already visited square
        }

        board[row][col] = moveCount; // Mark the current square as visited

        // Try all possible knight moves from the current position
        for (int i = 0; i < ROW_MOVES.length; i++) {
            int nextRow = row + ROW_MOVES[i];
            int nextCol = col + COL_MOVES[i];

            if (solveKnightsTour(board, nextRow, nextCol, moveCount + 1)) {
                return true; // Recursive call to explore the next move
            }
        }

        board[row][col] = 0; // Unmark the current square
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE]; // Chessboard to track knight's moves

        // Perform the knight's tour starting from the given position
        solveKnightsTour(board, 0, 0, 1);

        Utils.displayMatrix(board);
    }
}
