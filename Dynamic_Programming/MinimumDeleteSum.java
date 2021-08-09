class MinimumDeleteSum {

    // https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
    
    public int minimumDeleteSum(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[2][len2 + 1];
        int asc1 = 0, asc2 = 0;
        for (int i = 1 ; i <= len1 ; i++) {
            asc1 += text1.charAt(i - 1);
            for (int j = 1 ; j <= len2 ; j++) {
                int val = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    val = Math.max(val, dp[(i - 1) % 2][j - 1] + (int) text1.charAt(i - 1));
                }
                dp[i%2][j] = val;
            }
        }
        for (int i = 0 ; i < len2 ; i++) {
            asc2 += text2.charAt(i);
        }
        return asc1 + asc2 - 2 * dp[len1 % 2][len2];
    }
}