package google;

import utils.Utils;

import java.util.Random;

/**
 * Minesweeper is a game where the objective is correctly identify the location of all mines in a given grid. You are
 * given a uniform grid of gray squares in the beginning of the game. Each square contains either a mine (indicated by
 * a value of 9), or an empty square. Empty squares have a number indicating the count of mines in the adjacent squares.
 * Empty squares can have counts from zero (no adjacent mines) up to 8 (all adjacent squares are mines).
 * The squares with "2" indicate that there 2 mines adjacent to that particular square.
 * <p>
 * Gameplay starts with a user un-hiding a square at random. If the square contains a mine, the game ends. If it is a
 * blank, the number of adjacent mines is revealed.
 * <p>
 * Exposing a zero means that there are no adjacent mines, so exposing all adjacent squares is guaranteed safe. As a
 * convenience to the player, the game continues to expose adjacent squares until a non-zero square is reached.
 * <p>
 * For example, if you click on the top right corner you get this ('-' means hidden):
 * <p>
 * 0  0  0  0  0
 * 0  0  0  0  0
 * 1  1  1  0  0
 * -  -  1  0  0
 * -  -  2  1  0
 * -  -  -  1  0
 * -  -  -  1  0
 * <p>
 * Please write functions to construct the playing field given the size and number of mines.
 */
public class Minesweeper {
    private static final int MINE = 9;
    private static final int[] ROW_MOVES = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] COL_MOVES = {-1, 0, 1, -1, 1, -1, 0, 1};

    /**
     * @param rows     number of rows the play field should have
     * @param cols     number of cols the play field should have
     * @param numMines number of mines the play field should have
     * @return a play field
     */
    public int[][] generateField(int rows, int cols, int numMines) {
        //the play field is initialized with 0 by default
        int[][] field = new int[rows][cols];

        //1. place the mines randomly
        placeMines(field, numMines);

        //2. check the neighbours for mines
        calculateAdjacentMines(field);

        return field;
    }

    private void placeMines(int[][] field, int numMines) {
        int rows = field.length;
        int cols = field[0].length;
        Random random = new Random();

        while (numMines > 0) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (field[row][col] != MINE) {
                field[row][col] = MINE;
                numMines--;
            }
        }
    }

    private void calculateAdjacentMines(int[][] field) {
        int rows = field.length;
        int cols = field[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (field[row][col] != MINE) {
                    int count = 0;
                    //check all the 8 positions around field[row][col]
                    for (int i = 0; i < 8; i++) {
                        int newRow = row + ROW_MOVES[i];
                        int newCol = col + COL_MOVES[i];
                        //check first if that cell is not out of bounds
                        if (isValidCell(newRow, newCol, rows, cols) && field[newRow][newCol] == MINE) {
                            count++;
                        }
                    }
                    field[row][col] = count;
                }
            }
        }
    }

    private boolean isValidCell(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        int[][] field = minesweeper.generateField(6, 5, 6);
        Utils.displayMatrix(field);
    }
}
