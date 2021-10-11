package com.FacebookHackercup2021.Round2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

// https://www.facebook.com/codingcompetitions/hacker-cup/2021/round-2/problems/A

public class HackercupA {

    static final int CONST_MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        File file = new File("/home/nobroker/Desktop/input.txt");
        Scanner sc = new Scanner(file);
        FileWriter fileWriter = new FileWriter("/home/nobroker/Desktop/output.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] s = new int[m];
            for (int j = 0 ; j < m ; j++) {
                s[j] = sc.nextInt();
            }
            int[][] p = new int[n][m];
            for (int k = 0 ; k < n ; k++) {
                for (int j = 0; j < m; j++) {
                    p[k][j] = sc.nextInt();
                }
            }
            Multiset<Integer> A = HashMultiset.create();
            Multiset<Integer> D = HashMultiset.create();
            for (int j = 0 ; j < m ; j++) {
                A.add(s[j]);
                D.add(s[j]);
            }

            long count = 0L;
            for (int j = 0 ; j < n ; j++) {
                Multiset<Integer> B = HashMultiset.create();
                for (int k = 0 ; k < m ; k++) {
                    B.add(p[j][k]);
                }
                Multiset<Integer> AB = HashMultiset.create(A);
                Multisets.removeOccurrences(AB, B);
//                AB.removeAll(B);
                Multiset<Integer> ABD = HashMultiset.create(AB);
                Multisets.removeOccurrences(ABD, D);
//                ABD.removeAll(D);
                count += ABD.size();
                Multisets.removeOccurrences(D, AB);
//                D.removeAll(AB);
                A = HashMultiset.create(B);
            }
            printWriter.println("Case #" + i + ": " + count);
        }
        printWriter.close();
    }
}
