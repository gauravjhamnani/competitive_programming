package com.codeforces.Contest1566;

import java.util.Scanner;

// https://codeforces.com/contest/1566/problem/C

public class CGR3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(sc.nextLine());
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            long ans = 0;
            int lastEnc = -1;
            for (int j = 0 ; j < n ; j++) {
                if ((str1.charAt(j) == '0' && str2.charAt(j) == '1') ||
                        (str1.charAt(j) == '1' && str2.charAt(j) == '0')) {
                    ans += 2;
                    lastEnc = -1;
                } else if (str1.charAt(j) == '0' && str2.charAt(j) == '0') {
                    ans += 1;
                    if (lastEnc == 1) {
                        ans += 1;
                        lastEnc  = -1;
                    } else if (lastEnc == -1) {
                        lastEnc = 0;
                    }
                } else {
                    if (lastEnc == 0) {
                        ans += 1;
                        lastEnc = -1;
                    } else if (lastEnc == -1) {
                        lastEnc = 1;
                    }
                }
            }
            System.out.println(ans);
        }
    }

}
