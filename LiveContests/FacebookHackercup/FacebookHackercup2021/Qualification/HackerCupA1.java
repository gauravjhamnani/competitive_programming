package com.FacebookHackercup2021.Qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// https://www.facebook.com/codingcompetitions/hacker-cup/2021/qualification-round/problems/A1

public class HackerCupA1 {

    public static int solve(String s) {
        int n = s.length();
        List<Integer> vowelIndex = Arrays.asList(0, 'E' - 'A', 'I' - 'A', 'O' - 'A', 'U' - 'A');
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'A']++;
        }
        int consCount = 0, vowelCount = 0, consMax = 0, vowelMax = 0;
        for (int i = 0; i < 26; i++) {
            if (vowelIndex.contains(i)) {
                vowelCount += freq[i];
                if (freq[i] > vowelMax) {
                    vowelMax = freq[i];
                }
            } else {
                consCount += freq[i];
                if (freq[i] > consMax) {
                    consMax = freq[i];
                }
            }
        }
        return consCount + vowelCount + Math.min(consCount - 2 * consMax, vowelCount - 2 * vowelMax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            String s = sc.nextLine();
            int ans = solve(s);
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
