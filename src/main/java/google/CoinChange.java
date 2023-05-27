package google;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        //in dp we store the minimum number of coins for building the 'i' amount,
        //but using only the currencies iterated so far
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                //dp[i - coin] represents the minimum number of coins needed to form the amount 'i - coin'.
                //this condition checks if dp[i-coin] is a solution or not
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }
}
