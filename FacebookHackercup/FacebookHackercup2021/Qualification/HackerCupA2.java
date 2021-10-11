package com.FacebookHackercup2021.Qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// https://www.facebook.com/codingcompetitions/hacker-cup/2021/qualification-round/problems/A2

public class HackerCupA2 {

    public static final int INT_MAX = 100000;

    public static int solveA2(String s, List<String> list) {
        int n = s.length();
        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j) {
                    dist[i][j] = INT_MAX;
                }
            }
        }
        for (String pair : list) {
            int source = pair.charAt(0) - 'A';
            int dest = pair.charAt(1) - 'A';
            dist[source][dest] = 1;
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'A']++;
        }
        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            int minStepsItr = 0;
            for (int j = 0; j < 26; j++) {
                if (freq[j] != 0) {
                    if (dist[j][i] != INT_MAX) {
                        minStepsItr += dist[j][i] * freq[j];
                    } else {
                        minStepsItr = Integer.MAX_VALUE;
                        break;
                    }
                }
            }
            minSteps = Math.min(minSteps, minStepsItr);
        }
        return (minSteps != Integer.MAX_VALUE) ? minSteps : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            String s = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());
            List<String> list = new ArrayList<>();
            for (int j = 1; j <= k; j++) {
                String pair = sc.nextLine();
                list.add(pair);
            }
            int ans = solveA2(s, list);
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
