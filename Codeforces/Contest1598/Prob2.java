package com.codeforces.Contest1598;

import java.util.Scanner;

// https://codeforces.com/contest/1598/problem/B

public class Prob2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            int[][] arr = new int[n][5];
            for (int k = 0 ; k < n ; k++) {
                for (int j = 0; j < 5; j++) {
                    arr[k][j] = sc.nextInt();
                }
            }
            String ans = "NO";
            outer : for (int j = 0 ; j < 5 ; j++) {
                for (int k = j + 1 ; k < 5 ; k++) {
                    int zo = 0, oz = 0, zz = 0, oo = 0;
                    for (int m = 0 ; m < n ; m++) {
                        if (arr[m][j] == 0 && arr[m][k] == 1) {
                            zo++;
                        } else if (arr[m][j] == 1 && arr[m][k] == 0) {
                            oz++;
                        } else if (arr[m][j] == 1 && arr[m][k] == 1) {
                            oo++;
                        } else {
                            zz++;
                            break;
                        }
                    }
                    if (zz == 0 && ((zo + oo) >= (n / 2)) && (oz + oo) >= (n / 2)) {
                        ans = "YES";
                        break outer;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
