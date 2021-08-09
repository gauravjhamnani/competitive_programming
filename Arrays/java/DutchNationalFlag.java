class DutchNationalFlag {

    //  https://leetcode.com/problems/sort-colors/

    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ptr = l;
        while (l < r && ptr <= r) {
            if (nums[ptr] == 0) {
                swap(nums, l++, ptr++);
            } else if (nums[ptr] == 2) {
                swap(nums, r--, ptr);
            } else {
                ptr++;
            }
        }
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}