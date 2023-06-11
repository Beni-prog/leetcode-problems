package queues;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {

    public static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(0);
        visited.add(0);

        //in the first round, we will have all the perfect squares
        //in the interval [1, n]
        int round = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int num = queue.poll();

                if (num == n) {
                    return round;
                }

                //here we build the sum of squares, by adding the perfect squares added to the queue
                //to each perfect square in the range [1, n] and then we update the queue with these sums
                for (int j = 1; j * j <= n; j++) {
                    int next = num + j * j;

                    if (next > n) {
                        break;
                    }

                    //we don't want to take into considerations the same sum multiple times
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            round++;
        }
        return round;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(34));//2
        System.out.println(numSquares(13));//2
        System.out.println(numSquares(12));//3
        System.out.println(numSquares(4));//1
    }
}
