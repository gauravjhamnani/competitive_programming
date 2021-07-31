class MinCostTickets {

    // https://leetcode.com/problems/minimum-cost-for-tickets

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        dp[n - 1] = Math.min(costs[0], Math.min(costs[1], costs[2]));
        for (int i = n - 2 ; i >= 0 ; i--) {
            // 1 day
            int ans = costs[0] + dp[i + 1];
            
            // 7 day
            int nextIndex = findLowerBoundIndex(days[i] + 7, days);
            int alreadyCalCost = (nextIndex < n && nextIndex >= 0) ? dp[nextIndex] : 0; 
            ans = Math.min(ans, alreadyCalCost + costs[1]);
            
            // 30day
            nextIndex = findLowerBoundIndex(days[i] + 30, days);
            alreadyCalCost = (nextIndex < n && nextIndex >= 0) ? dp[nextIndex] : 0; 
            ans = Math.min(ans, alreadyCalCost + costs[2]);
            
            dp[i] = ans;
        }
        return dp[0];
    }
    
    private int findLowerBoundIndex(int val, int[] days) {
        int n = days.length;
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (val == days[mid]) {
                return mid;
            } else if (val < days[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}