import java.lang.Math;

// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3820/

class Solution {
    
    private final int[] originalArray;

    public Solution(int[] nums) {
        originalArray = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArray;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        LinkedList<Integer> list = new LinkedList<>();
        int len = originalArray.length;
        int[] ans = new int[len];
        int itr = 0;
        for (int i = 0 ; i < len ; i++) {
            list.add(originalArray[i]);
        }
        while (len > 0) {
            int pos = (int)(Math.random() * len);
            ans[itr++] = list.get(pos);
            list.remove(pos);
            len--;
        }
        return ans;
    }
}