package google;

import utils.Utils;

public class GameOfLife {

    public static void gameOfLife(int[][] board) {
        int[][] newState = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (getNeighbors(i, j, board) < 2) {
                        newState[i][j] = 0;
                    } else if (getNeighbors(i, j, board) < 4) {
                        newState[i][j] = 1;
                    } else {
                        newState[i][j] = 0;
                    }
                } else if (getNeighbors(i, j, board) == 3) {
                    newState[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(newState[i], 0, board[i], 0, board[0].length);
        }

        Utils.displayMatrix(board);
    }

    private static int getNeighbors(int i, int j, int[][] board) {
        int sum = 0;

        if (i - 1 >= 0) {
            sum += board[i - 1][j];
        }

        if (j - 1 >= 0) {
            sum += board[i][j - 1];
        }

        if (i + 1 < board.length) {
            sum += board[i + 1][j];
        }

        if (j + 1 < board[0].length) {
            sum += board[i][j + 1];
        }

        if (i - 1 >= 0 && j + 1 < board[0].length) {
            sum += board[i - 1][j + 1];
        }

        if (i + 1 < board.length && j - 1 >= 0) {
            sum += board[i + 1][j - 1];
        }

        if (i - 1 >= 0 && j - 1 >= 0) {
            sum += board[i - 1][j - 1];
        }

        if (i + 1 < board.length && j + 1 < board[0].length) {
            sum += board[i + 1][j + 1];
        }

        return sum;
    }

    public static void main(String[] args) {
        gameOfLife(new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 1}, new int[]{1, 1, 1}, new int[]{0, 0, 0}});
    }
}
