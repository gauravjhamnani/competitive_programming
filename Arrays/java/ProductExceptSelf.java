class ProductExceptSelf {

    // https://leetcode.com/problems/product-of-array-except-self

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] rP = new int[n];
        int[] lP = new int[n];
        lP[0] = 1;
        for (int i = 1 ; i < n ; i++) {
            lP[i] = lP[i - 1] * nums[i - 1]; 
        }
        rP[n - 1] = 1;
        for (int i = n - 2 ; i >= 0 ; i--) {
            rP[i] = rP[i + 1] * nums[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0 ; i < n ; i++) {
            ans[i] = lP[i] * rP[i];
        }
        return ans;
    }
}