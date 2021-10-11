package com.codeforces.Contest1566;

import java.util.Scanner;

// https://codeforces.com/contest/1566/problem/D1

public class CGR4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[m + 1];
            for (int i = 0 ; i < n*m ; i++) {
                int val = sc.nextInt();
                arr[i] = val;
            }
            Long count = 0L;
            for (int i = 1 ; i <= m ; i++) {
               for (int j = i -1 ; j >= 0 ; j--) {
                   if (arr[j] < arr[i]) {
                       count++;
                   }
               }
            }
            System.out.println(count);
            t--;
        }
    }

}
