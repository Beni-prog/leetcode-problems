package google;

import utils.Utils;

public class NQueens {

    static int[][] getQueensPositionsOnChessBoard(int n) {
        int[][] solutions = new int[n][n];

        backtrack(n, solutions, 0);
        return solutions;
    }

    static boolean backtrack(int n, int[][] solutions, int col) {
        //base case: if all queens are placed,
        //then return true
        if (col == n) {
            return true;
        }

        //Consider this column and try placing this queen in all rows one by one
        for (int i = 0; i < solutions.length; i++) {
            //check if the queen can be placed on solutions[i][col]
            if (positionIsSuitable(solutions, i, col)) {
                solutions[i][col] = 1;
                //recur to place rest of the queens
                if (backtrack(n, solutions, col + 1)) {
                    return true;
                }
                //if placing queen in solutions[i][col] doesn't lead to a solution,
                //then remove queen from board[i][col]
                solutions[i][col] = 0; //BACKTRACK
            }
        }

        return false;
    }

    static boolean positionIsSuitable(int[][] matrix, int row, int col) {
        int i, j;

        //check this row on left side
        for (i = 0; i < col; i++)
            if (matrix[row][i] == 1)
                return false;

        //check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (matrix[i][j] == 1)
                return false;

        //check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < matrix.length; i++, j--)
            if (matrix[i][j] == 1)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Utils.displayMatrix(getQueensPositionsOnChessBoard(4));
        Utils.displayMatrix(getQueensPositionsOnChessBoard(5));
    }
}
