class MinMoves {

    // https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

    public int minMoves(int[] nums) {
        int min = (int) 1e9;
        for (int i = 0 ; i < nums.length ; i++) {
            min = Math.min(min, nums[i]);
        }
        int ans = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            ans += nums[i] - min;
        }
        return ans;
    }
}