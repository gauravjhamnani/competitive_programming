public class BitonicSearchOnePass {


    // https://www.interviewbit.com/problems/search-in-bitonic-array/
    /**
    * This code used only 2*logn comaprisons in worst case
    */
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int  l = 0, r = A.size(), mid = 0, rhnp = 0, lhnp = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (A.get(mid) == B) {
                return mid;
            } else if (((mid == 0) || A.get(mid - 1) < A.get(mid)) && ((mid == (n - 1)) || A.get(mid + 1) > A.get(mid))) {
                if ((lhnp == 1) || B > A.get(mid)) {
                    l = mid + 1;
                } else {
                    int fIndex = Collections.binarySearch(A.subList(0, mid), B);
                    if (fIndex >= 0) {
                        return fIndex;
                    } else {
                        lhnp = 1;
                    }
                }
            } else if (((mid == 0) || A.get(mid - 1) > A.get(mid)) && ((mid == (n - 1)) || A.get(mid + 1) < A.get(mid))) {
                if ((rhnp == 1) || B > A.get(mid)) {
                    r = mid;
                } else {
                    int fIndex = Collections.binarySearch(A.subList(mid, n), B, Collections.reverseOrder());
                    if (fIndex >= 0) {
                        return fIndex;
                    } else {
                        rhnp = 1;
                    }
                }
            } else {
                int lHalf = Collections.binarySearch(A.subList(l, mid), B);
                int rHalf = Collections.binarySearch(A.subList(mid, r), B, Collections.reverseOrder());
                if (lHalf >= 0) {
                    return lHalf;
                } else if (rHalf >= 0) {
                    return mid + rHalf;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
