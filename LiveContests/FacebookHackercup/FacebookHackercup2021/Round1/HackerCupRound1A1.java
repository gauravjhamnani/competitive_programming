package com.FacebookHackercup2021.Round1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// https://www.facebook.com/codingcompetitions/hacker-cup/2021/round-1/problems/A1

public class HackerCupRound1A1 {

    public static int solve(String s) {
        int n = s.length();
        int ans = 0, i = 0;
        char curr = 'F';
        for (i = 0 ; i < n ; i++) {
            if (s.charAt(i) == 'X') {
                curr = 'X';
                break;
            } else if (s.charAt(i) == 'O') {
                curr = 'O';
                break;
            }
        }
        i++;
        while (i < n) {
            if (s.charAt(i) != 'F') {
                if (s.charAt(i) != curr) {
                    curr = s.charAt(i);
                    ans++;
                }
            }
            i++;
        }
        return ans;
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
            int ans = solve(s);
            printWriter.println("Case #" + i + ": " + ans);
        }
        printWriter.close();
    }

}
