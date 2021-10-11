class CombinationsCountThatSumUpToTarget {

    // https://leetcode.com/problems/coin-change-2

    public int change(int amount, int[] coins) {
        int coinSize = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coinSize; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}