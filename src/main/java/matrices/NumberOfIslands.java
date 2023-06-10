package matrices;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int noOfIslands = 0;

        //iterate over the grid and when 1 is encountered, count it
        //and check every cell that is part of that island and mark as visited, aka as 0,
        //using DFS
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == '1') {
                    noOfIslands++;
                    dfs(grid, row, column);
                }
            }
        }
        return noOfIslands;
    }

    public static void dfs(char[][] grid, int row, int column) {

        //if we are off the grid or the cell is not land, return
        if (row > grid.length || row < 0 || column < 0 || column > grid[0].length || grid[row][column] != '1') {
            return;
        }

        //mark this cell as visited, not to be counted multiple times
        grid[row][column] = '0';

        //explore every cell that is part of this island
        dfs(grid, row + 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row - 1, column);
        dfs(grid, row, column  -1);
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));//1

        System.out.println(numIslands(new char[][] {
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));//3
    }
}
