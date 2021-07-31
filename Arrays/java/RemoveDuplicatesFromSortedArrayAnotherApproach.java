class RemoveDuplicatesFromSortedArrayAnotherApproach {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int nextDis = 1, curr = 1;
        while (nextDis < n) {
           if (nums[nextDis] != nums[nextDis - 1]) {
               nums[curr++] = nums[nextDis];
           }
           nextDis++;
        }
        return curr;
    }
}
