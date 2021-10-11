class FirstAndLastPositionArray {

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Figure out how to do it in one pass

    public int[] searchRange(int[] a, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int  l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < target) l = mid + 1;
            else r = mid - 1; 
        }
        if (l < a.length  && a[l] == target) ans[0] = l;
        else return ans;
        l = 0;
        r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] <= target) l = mid + 1;
            else r = mid - 1; 
        }
        ans[1] = r;
        return ans;
    }
}
