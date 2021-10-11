package com.codeforces.Contest1566;

import java.io.IOException;
import java.util.Scanner;

// https://codeforces.com/contest/1566/problem/A

public class CGR1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int newN = 1 + (n / 2);
            int ans = s / newN;
            System.out.println(ans);
        }
    }
}
