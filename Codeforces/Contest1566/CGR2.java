package com.codeforces.Contest1566;

import java.util.Scanner;

// https://codeforces.com/contest/1566/problem/B

public class CGR2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            String str = sc.nextLine();
            int zCount = 0, oCount = 0;
            for (int j = 0 ; j < str.length() ; j++) {
                if (str.charAt(j) == '0') {
                    zCount++;
                } else {
                    oCount++;
                }
            }
            int ans = 1;
            if (zCount == 0) {
              ans = 0;
            } else if (oCount == 0) {
                ans = 1;
            } else {
                int pCount = 0;
                for (int j = 0 ; j < str.length() - 1 ; j++) {
                    if (pCount > 0 && str.charAt(j) == '0') {
                        ans = 2;
                        break;
                    }
                    if (str.charAt(j) == '0' && str.charAt(j + 1) == '1') {
                        pCount++;
                    }
                }
                if (pCount > 0 && str.charAt(str.length() - 1) == '0') {
                    ans = 2;
                }
            }
            System.out.println(ans);
        }
    }
}
