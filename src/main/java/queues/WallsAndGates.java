package queues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    private static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void wallsAndGates(int[][] rooms) {
        Queue<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Integer[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer[] cell = queue.poll();

            for (int[] direction : directions) {
                int newRow = cell[0] + direction[0];
                int newColumn = cell[1] + direction[1];

                if (newRow >= 0 && newRow < rooms.length && newColumn >= 0 && newColumn < rooms[0].length && rooms[newRow][newColumn] == Integer.MAX_VALUE) {
                    rooms[newRow][newColumn] = rooms[cell[0]][cell[1]] + 1;
                    queue.offer(new Integer[]{newRow, newColumn});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };

        wallsAndGates(rooms);

        for (int[] row : rooms) {
            System.out.println(Arrays.toString(row));
        }
    }
}
