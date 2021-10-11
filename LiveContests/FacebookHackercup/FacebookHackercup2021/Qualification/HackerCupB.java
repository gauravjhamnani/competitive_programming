package com.FacebookHackercup2021.Qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// https://www.facebook.com/codingcompetitions/hacker-cup/2021/qualification-round/problems/B

public class HackerCupB {

    class Tuple {
        int r;
        int c;
        public Tuple(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tuple)) return false;
            Tuple tuple = (Tuple) o;
            return r == tuple.r &&
                    c == tuple.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    private String solveB(List<String> list, int n) {
        int[] ans = new int[n + 1];
        List<Tuple> oneGridList = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            boolean flag = false;
            int dotCount = 0;
            String str = list.get(row);
            int lastDotPos = -1;
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                if (ch == 'O') {
                    flag = true;
                    break;
                } else if (ch == '.') {
                    lastDotPos = i;
                    dotCount++;
                }
            }
            if (!flag) {
                if (dotCount == 1) {
                    Tuple tuple = new Tuple(row, lastDotPos);
                    if (!oneGridList.contains(tuple)) {
                        oneGridList.add(tuple);
                        ans[dotCount]++;
                    }
                } else {
                    ans[dotCount]++;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            boolean flag = false;
            int dotCount = 0;
            int lastDotPos = -1;
            for (int i = 0; i < n; i++) {
                char ch = list.get(i).charAt(j);
                if (ch == 'O') {
                    flag = true;
                    break;
                } else if (ch == '.') {
                    lastDotPos = i;
                    dotCount++;
                }
            }
            if (!flag) {
                if (dotCount == 1) {
                    Tuple tuple = new Tuple(lastDotPos, j);
                    if (!oneGridList.contains(tuple)) {
                        oneGridList.add(tuple);
                        ans[dotCount]++;
                    }
                } else {
                    ans[dotCount]++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (ans[i] != 0) {
                return i + " " + ans[i];
            }
        }
        return "Impossible";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(sc.nextLine());
            List<String> list = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                String str = sc.nextLine();
                list.add(str);
            }
            String ans = new HackerCupB().solveB(list, n);
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
