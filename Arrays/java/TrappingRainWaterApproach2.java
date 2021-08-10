class TrappingRainWaterApproach2 {

    // https://leetcode.com/problems/trapping-rain-water 

    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1, cw = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                int ch = height[left++];
                while (height[left] < ch) {
                    cw += ch - height[left++];
                }
            } else {
                int ch = height[right--];
                while (height[right] < ch) {
                    cw += ch - height[right--];
                }
            }
        }
        return cw;
    }
}