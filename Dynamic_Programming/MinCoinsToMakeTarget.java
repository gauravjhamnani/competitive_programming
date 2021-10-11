class MinCoinsToMakeTarget {

    // https://leetcode.com/problems/coin-change/

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.setAll(dp, p -> p != 0 ? -1 : 0);
        for (int i = 1; i <= amount; i++) {
            int val = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    val = Math.min(val, 1 + dp[i - coin]);
                }
            }
            if (val != Integer.MAX_VALUE) {
                dp[i] = val;
            }
        }
        return dp[amount];
    }
}