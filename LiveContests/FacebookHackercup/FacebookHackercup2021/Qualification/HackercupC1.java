package com.FacebookHackercup2021.Qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// https://www.facebook.com/codingcompetitions/hacker-cup/2021/qualification-round/problems/C1

public class HackercupC1 {

    static class Tuple {
        int r;
        int c;

        public Tuple(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof HackerCupB.Tuple)) return false;
            HackerCupB.Tuple tuple = (HackerCupB.Tuple) o;
            return r == tuple.r &&
                    c == tuple.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; ++i) {
            int n = Integer.parseInt(sc.nextLine());
            List<Long> cost = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                Long c = sc.nextLong();
                cost.add(c);
            }
            List<Tuple> tupleList = new ArrayList<>();
            for (int j = 1; j < n; j++) {
                int s = sc.nextInt();
                int d = sc.nextInt();
                tupleList.add(new Tuple(s, d));
//                System.out.print(tupleList.get(j - 1).r + " " + tupleList.get(j - 1).c);
            }
            sc.nextLine();
            Long ans = solveC1(n, cost, tupleList);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static Long solveC1(int n, List<Long> cost, List<Tuple> tupleList) {
        List<Integer>[] adjList = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (Tuple tuple : tupleList) {
            adjList[tuple.r].add(tuple.c);
            adjList[tuple.c].add(tuple.r);
        }
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Long max1 = 0L, max2 = 0L;
        for (int root : adjList[1]) {
            Long[] max= new Long[1];
            max[0] = 0L;
            dfs(adjList, root, visited, 0L, cost, max);
            if (max[0] > max1) {
                max2 = max1;
                max1 = max[0];
            } else if (max[0] > max2) {
                max2 = max[0];
            }
        }
        return cost.get(0) + max2 + max1;
    }

    private static void dfs(List<Integer>[] adjList, int currNode, boolean[] visited, Long currSum, List<Long> cost, Long[] max) {
        visited[currNode] = true;
        for (int neighbour : adjList[currNode]) {
            if (!visited[neighbour]) {
                dfs(adjList, neighbour, visited, currSum + cost.get(currNode - 1), cost, max);
            }
        }
        max[0] = Math.max(max[0], currSum + cost.get(currNode - 1));
    }
}
