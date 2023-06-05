package matrices;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();

        //use 3 maps, having as keys the row, column and a custom index for the box validation
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] != '.') {

                    //check row
                    if (!rowMap.containsKey(row)) {
                        rowMap.put(row, new HashSet<>());
                    }
                    if (rowMap.get(row).contains(board[row][column])) {
                        return false;
                    }
                    rowMap.get(row).add(board[row][column]);

                    //check column
                    if (!columnMap.containsKey(column)) {
                        columnMap.put(column, new HashSet<>());
                    }
                    if (columnMap.get(column).contains(board[row][column])) {
                        return false;
                    }
                    columnMap.get(column).add(board[row][column]);

                    //check box
                    int boxIndex = (row / 3) * 3 + column / 3;
                    if (!boxMap.containsKey(boxIndex)) {
                        boxMap.put(boxIndex, new HashSet<>());
                    }
                    if (boxMap.get(boxIndex).contains(board[row][column])) {
                        return false;
                    }
                    boxMap.get(boxIndex).add(board[row][column]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));

        System.out.println(isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}
