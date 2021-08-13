class MedianSortedArrays {
    
    // https://leetcode.com/problems/median-of-two-sorted-arrays/

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0 && n == 0) {
            return 0.0;
        }
        if (m == 1 && n == 0) return nums1[0];
        if (m == 0 && n == 1) return nums2[0];
        int sum = m + n;
        if (sum % 2 == 0) {
            return (findKthElement(nums1, nums2, (sum / 2) + 1) + findKthElement(nums1, nums2, sum / 2)) / 2.0;
        } else {
            return 1.0 * findKthElement(nums1, nums2, sum / 2 + 1);
        }
    }
    
    private int findKthElement(int[] nums1, int[] nums2, int k) {
        int l1 = 0, r1 = nums1.length - 1;
        int l2 = 0, r2 = nums2.length - 1;
        while (l1 <= r1 && l2 <= r2) {
            int mid1 = l1 + (r1 - l1) / 2;
            int mid2 = l2 + (r2 - l2) / 2;
            int pos = findUpperBound(nums1, nums2[mid2], l1, r1);
            int posFound = mid2 - l2 + pos - l1 + 1;
            if (posFound == k) {
                return nums2[mid2];
            } else if (posFound > k) {
                r2 = mid2 - 1;
                r1 = pos - 1;
            } else {
                l1 = pos;
                l2 = mid2 + 1;
                k = k - posFound;
            }
        }
        if (l1 > r1) {
            return nums2[l2 + k - 1];
        } else {
            return nums1[l1 + k - 1];
        }
    }
    
    private int findUpperBound(int[] a, int el, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] <= el) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}