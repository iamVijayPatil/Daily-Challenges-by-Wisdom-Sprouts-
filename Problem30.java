

/*
You are given an integer array coins[] of size n, where each element represents the denomination of a coin. You are also given an integer amount, representing the total amount of money. The task is to find the minimum number of coins required to make up the given amount.
If the amount cannot be formed by any combination of the coins, return -1.
You can assume that you have an infinite supply of each denomination.


Input:
An integer array coins[] where each element represents the value of a coin.
An integer amount representing the total amount of money.

Output:
Return the minimum number of coins needed to make up the amount.
If the amount cannot be formed by any combination of coins, return -1.

Examples:
Example 1
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: To make the amount 11, the fewest number of coins is 3 (5 + 5 + 1).

 */
import java.util.Arrays;

public class Problem30 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(minimumCoins(coins, amount)); // Output: 3
    }

    public static int minimumCoins(int[] coins, int amount) {
        // dp[i] will store the minimum number of coins needed for amount i
        int[] dp = new int[amount + 1];

        // Fill with a large number (representing infinity)
        Arrays.fill(dp, amount + 1);

        dp[0] = 0; // Base case: 0 coins needed for amount 0

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
