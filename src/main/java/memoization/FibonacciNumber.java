package memoization;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n < 2) {
            return n;
        } else {
            int result = fib(n - 1) + fib(n - 2);
            cache.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
