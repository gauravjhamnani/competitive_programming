package com.FacebookHackercup2021.Round1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// https://www.facebook.com/codingcompetitions/hacker-cup/2021/round-1/problems/B

public class HackerCupRound1B1 {

    private static void solve(int m, int n, int a, int b, int caseNum, PrintWriter printWriter) {
        if (a < (m + n - 1) || b < (m + n - 1)) {
            printWriter.println("Case #" + caseNum + ": Impossible");
            return;
        } else {
            printWriter.println("Case #" + caseNum + ": Possible");
            for (int i = 0 ; i < m ; i++) {
                for (int j = 0 ; j < n - 1 ; j++) {
                    if (i == (m - 1)) {
                        printWriter.print("1 ");
                    } else {
                        if (j != 0) {
                            printWriter.print("1000 ");
                        } else {
                            if (i == 0) {
                                printWriter.print(a - (m + n - 2) + " ");
                            } else {
                                printWriter.print("1 ");
                            }
                        }
                    }
                }
                if (i == 0) {
                    printWriter.print(b - (m + n - 2));
                } else {
                    printWriter.print(1);
                }
                printWriter.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/home/nobroker/Desktop/input.txt");
        FileWriter fileWriter = new FileWriter("/home/nobroker/Desktop/output.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        Scanner sc= new Scanner(file);
        int t = sc.nextInt();
        for (int i = 1 ; i <= t ; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            solve(m, n, a, b, i, printWriter);
        }
        printWriter.close();
    }
}
