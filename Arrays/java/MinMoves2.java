class MinMoves2 {

    // https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            ans += nums[j--] - nums[i++];
        }
        return ans;
    }
}