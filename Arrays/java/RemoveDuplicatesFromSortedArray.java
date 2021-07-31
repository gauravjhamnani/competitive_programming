class RemoveDuplicatesFromSortedArray {

    // https://leetcode.com/problems/remove-duplicates-from-sorted-array

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int nextDis = 1, curr = 1;
        while (nextDis < n) {
            while (nextDis < n && nums[nextDis] == nums[nextDis - 1]) {
                nextDis++;
            }
            if (nextDis < n) {
                nums[curr++] = nums[nextDis++];
            }
        }
        return curr;
    }
}
