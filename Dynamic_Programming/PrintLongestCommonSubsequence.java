class PrintLongestCommonSubsequence {
    
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1 ; i <= len1 ; i++) {
            for (int j = 1 ; j <= len2 ; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int i = len1, j = len2;
        String s = "";
        while (i >= 1 && j >= 1) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                s = text1.charAt(i - 1) + s;
                i--;j--;
            } else {
                if (dp[i - 1][j] > dp [i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        System.out.println(s);
        return dp[len1][len2];
    }
}