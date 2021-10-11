package com.FacebookHackercup2021.Round1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// https://www.facebook.com/codingcompetitions/hacker-cup/2021/round-1/problems/A2

public class HackercupRound1A2 {

    static final int CONST_MOD = 1000000007;

    public static long solve(String s) {
        int n = s.length();
        int i = 0;
        char currChar = 'F';
        long currFSum = 0, mulSum = 0, plainSum = 0, ans = 0;
        while (i < n) {
            if (s.charAt(i) == 'F') {
                currFSum = 0;
                while (i < n && s.charAt(i) == 'F') {
                    currFSum++;
                    i++;
                    ans += mulSum;
                    ans = ans % CONST_MOD;
                }
            } else {
                if (s.charAt(i) == currChar) {
                    plainSum += currFSum;
                    currFSum = 0;
                    while (i < n && s.charAt(i) == currChar) {
                        ans += mulSum;
                        ans = ans % CONST_MOD;
                        plainSum++;
                        i++;
                    }
                } else {
                    mulSum += plainSum;
                    mulSum = mulSum % CONST_MOD;
                    currChar = s.charAt(i);
                }
            }
        }
        return ans % CONST_MOD;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/home/nobroker/Desktop/input.txt");
        Scanner sc = new Scanner(file);
        FileWriter fileWriter = new FileWriter("/home/nobroker/Desktop/output.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            String str = sc.nextLine();
            String s = sc.nextLine();
            long ans = solve(s);
            printWriter.println("Case #" + i + ": " + ans);
        }
        printWriter.close();
    }
}
