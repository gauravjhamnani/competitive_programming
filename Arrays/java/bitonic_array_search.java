public class Solution {

    https://www.interviewbit.com/problems/search-in-bitonic-array/

    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int  l = 0, r = A.size(), mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (((mid == 0) || A.get(mid - 1) < A.get(mid)) && ((mid == (n - 1)) || A.get(mid + 1) > A.get(mid))) {
                mid = l + 1;
            } else if (((mid == 0) || A.get(mid - 1) > A.get(mid)) && ((mid == (n - 1)) || A.get(mid + 1) < A.get(mid))) {
                mid = r;
            } else {
                break;
            }
        }
        int lHalf = Collections.binarySearch(A.subList(0, mid), B);
        int rHalf = Collections.binarySearch(A.subList(mid, A.size()), B, Collections.reverseOrder());
        if (lHalf >= 0) {
            return lHalf;
        } else if (rHalf >= 0) {
            return mid + rHalf;
        } else {
            return -1;
        }
    }
}