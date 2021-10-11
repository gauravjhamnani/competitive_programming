package com.codeforces.Contest1598;

import java.util.Scanner;

// https://codeforces.com/contest/1598/problem/A

public class Prob1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(sc.nextLine());
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String ans = "YES";
            for (int j = 0 ; j < n ; j++) {
                if (str1.charAt(j) == '1' && str2.charAt(j) == '1') {
                    ans = "NO";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
