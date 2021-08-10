class productExceptSelfApproach2 {

    // https://leetcode.com/problems/product-of-array-except-self

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1 ; i < n ; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int tempP = 1;
        for (int i = n - 2 ; i >= 0 ; i--) {
            tempP = tempP * nums[i + 1];
            ans[i] = ans[i] * tempP;
        }
        return ans;
    }
}