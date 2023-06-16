package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(0, visited, rooms);

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(int currentRoom, boolean[] visited, List<List<Integer>> rooms) {
        visited[currentRoom] = true;

        for (int i = 0; i < rooms.get(currentRoom).size(); i++) {
            if (!visited[rooms.get(currentRoom).get(i)]) {
                dfs(rooms.get(currentRoom).get(i), visited, rooms);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(Collections.singletonList(1));
        list.add(Collections.singletonList(2));
        list.add(Collections.emptyList());
        list.add(Collections.singletonList(3));

        System.out.println(canVisitAllRooms(list));
    }
}
