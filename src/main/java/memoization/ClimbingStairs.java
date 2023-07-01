package memoization;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int climbStairs(int n) {
        return climb(n);
    }

    private static int climb(int n) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n <= 2) {
            return n;
        } else {
            int result = climb(n - 1) + climb(n - 2);
            cache.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));//5
    }
}
