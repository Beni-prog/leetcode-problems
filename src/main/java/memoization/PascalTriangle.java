package memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle {

    private static Map<String, Integer> memo;

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        memo = new HashMap<>();
        for (int i = 0; i <= rowIndex; i++) {
            row.add(getCoefficient(rowIndex, i));
        }
        return row;
    }

    private static int getCoefficient(int n, int k) {
        String key = n + "-" + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (k == 0 || k == n) {
            return 1;
        } else {
            int coefficient = getCoefficient(n - 1, k - 1) + getCoefficient(n - 1, k);
            memo.put(key, coefficient);
            return coefficient;
        }
    }

    public static void main(String[] args) {
        System.out.println(getRow(30));
    }
}
