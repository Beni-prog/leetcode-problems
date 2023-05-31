package integers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (true) {
            if (n == 1) {
                return true;
            }
            if (visited.contains(n)) {
                return false;
            }

            //if we find it here, it means we entered the cycle
            visited.add(n);
            n = getSumOfSquares(n);
        }
    }

    public static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
}
