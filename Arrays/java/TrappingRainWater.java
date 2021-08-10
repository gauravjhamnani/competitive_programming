class TrappingRainWater {

    // https://leetcode.com/problems/trapping-rain-water/

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int maxI = 0;
        for (int i = 0 ; i < n ; i++) {
            if (height[i] > height[maxI]) {
                maxI = i;
            }
        }
        int i = 1, maxHeight = height[0], water = 0, tempYSum = 0, tempXSum = 0;
        while (i <= maxI) {
            if (height[i] >= maxHeight) {
                water += tempXSum * maxHeight - tempYSum;
                tempXSum = tempYSum = 0;
                maxHeight = height[i];
            } else {
                tempXSum++;
                tempYSum += height[i];
            }
            i++;
        }
        i = n - 2;
        maxHeight = height[n - 1];
        while (i >= maxI) {
            if (height[i] >= maxHeight) {
                water += tempXSum * maxHeight - tempYSum;
                tempXSum = tempYSum = 0;
                maxHeight = height[i];
            } else {
                tempXSum++;
                tempYSum += height[i];
            }
            i--;
        }
        return water;
    }
}