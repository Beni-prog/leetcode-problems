package queues;

import java.util.*;

public class OpenLock {

    public static int openLock(String[] deadends, String target) {
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String start = "0000";
        if (deadendsSet.contains(start)) {
            return -1;
        }

        queue.offer(start);
        visited.add(start);

        int turns = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return turns;
                }

                //get 8 combinations from this current state,
                //by rotating the wheel up and down once for each position
                List<String> neighbors = getNeighbors(current);

                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor) && !deadendsSet.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            turns++;
        }

        return -1;
    }

    private static List<String> getNeighbors(String lock) {
        List<String> neighbors = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            char[] lockChars = lock.toCharArray();

            // Rotate the wheel up
            //modulo operation is for remaining in the range 0-9
            //we subtract 0 char for converting the char to int
            lockChars[i] = (char) ((lockChars[i] - '0' + 1) % 10 + '0');
            neighbors.add(new String(lockChars));

            lockChars = lock.toCharArray();

            // Rotate the wheel down
            lockChars[i] = (char) ((lockChars[i] - '0' + 9) % 10 + '0');
            neighbors.add(new String(lockChars));
        }

        return neighbors;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(openLock(new String[]{"8888"}, "0009"));
        System.out.println(openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
    }
}
