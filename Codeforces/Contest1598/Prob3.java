package com.codeforces.Contest1598;

import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/contest/1598/problem/C

public class Prob3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            Long sum = 0L;
            for (int j = 0 ; j < n ; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            if ((2 * sum) % n != 0) {
                System.out.println(0);
                continue;
            }
            Long mean = (2 * sum) / n;
            Arrays.sort(arr);
            Long ans = 0L;
            for (int k = 0 ; k < n - 1 ; k++) {
                int f = first(arr, k + 1, n - 1, (int)(mean - arr[k]), n);
                int s = last(arr, k + 1, n - 1, (int)(mean - arr[k]), n);
                if (f != -1) {
                    ans += s - f + 1;
                }
            }
            System.out.println(ans);
        }
    }

    static int first(int arr[], int low, int high, int x, int n)
    {
        int res = -1;
        while (low <= high)
        {
            // Normal Binary Search Logic
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;

                // If arr[mid] is same as
                // x, we update res and
                // move to the left half.
            else
            {
                res = mid;
                high = mid - 1;
            }
        }
        return res;
    }

    static int last(int arr[], int low, int high, int x, int n)
    {
        int res = -1;
        while (low <= high)
        {
            // Normal Binary Search Logic
            int mid = (low + high) / 2;
            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;

                // If arr[mid] is same as x,
                // we update res and move to
                // the right half.
            else
            {
                res = mid;
                low = mid + 1;
            }
        }
        return res;
    }
}
