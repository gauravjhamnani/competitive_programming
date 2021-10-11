class Solution {

    // https://leetcode.com/problems/wiggle-subsequence/

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int l = 1, u = 1;
        for (int i = 1 ; i < n ; i++) {
            if (nums[i - 1] > nums[i]) {
                l = 1 + u;
            } else if (nums[i - 1] < nums[i]) {
                u = 1 + l;
            }
        }
        return Math.max(l, u);
    }
}