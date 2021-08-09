class LongestCommonSubsequenceLength {

     // https://leetcode.com/problems/longest-common-subsequence
    
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[2][len2 + 1];
        for (int i = 1 ; i <= len1 ; i++) {
            for (int j = 1 ; j <= len2 ; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i%2][j] = dp[(i - 1) % 2][j - 1] + 1;
                } else {
                    dp[i%2][j] = Math.max(dp[i % 2][j - 1], dp[(i - 1) % 2][j]);
                }
            }
        }
        return dp[len1 % 2][len2];
    }
}