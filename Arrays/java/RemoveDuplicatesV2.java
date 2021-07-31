class RemoveDuplicatesV2 {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int curr = (n > 1 && nums[0] == nums[1]) ? 2 : 1;
        int nextDis = curr;
        while (nextDis < n) {
            if (nums[nextDis] != nums[nextDis - 1]) {
                nums[curr++] = nums[nextDis++];
                if (nextDis < n && nums[nextDis] == nums[nextDis - 1]) {
                    nums[curr++] = nums[nextDis++];
                }
            } else {
                nextDis++;
            }
        }
        return curr;
    }
}