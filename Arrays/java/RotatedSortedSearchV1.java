class RotatedSortedSearchV1 {

    // https://leetcode.com/problems/search-in-rotated-sorted-array

    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[n - 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        int pos1 = Arrays.binarySearch(nums, 0, hi + 1, target);
        if (pos1 >= 0) {
            return pos1;
        }
        int pos2 = Arrays.binarySearch(nums, lo, n, target);
        if (pos2 >= 0) {
            return pos2;
        }
        return -1;
    }
}