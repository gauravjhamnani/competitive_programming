package com.GoogleKickstart.RoundF2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

// https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435bae/0000000000887c32

public class TrashBins_Prob1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                int n = Integer.parseInt(in.nextLine());
                String arr = in.nextLine();
                int[] dist = new int[n];
                Arrays.fill(dist, Integer.MAX_VALUE);
                int leftNearestBin = -1;
                for (int j = 0 ; j < n ; j++) {
                    if (arr.charAt(j) == '1') {
                        leftNearestBin = j;
                    }
                    if (leftNearestBin != -1) {
                        dist[j] = Math.min(dist[j], j - leftNearestBin);
                    }
                }
                int rightNearestBin = -1;
                for (int j = n - 1 ; j >= 0 ; j--) {
                    if (arr.charAt(j) == '1') {
                        rightNearestBin = j;
                    }
                    if (rightNearestBin != -1) {
                        dist[j] = Math.min(dist[j], rightNearestBin - j);
                    }
                }
                long sum = 0;
                for (int j = 0 ; j < n ; j++) {
                    sum += dist[j];
                }
                System.out.println("Case #" + i + ": " + sum);
            }
        }
}
