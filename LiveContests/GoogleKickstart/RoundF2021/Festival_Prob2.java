package com.GoogleKickstart.RoundF2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435bae/0000000000887dba

public class Festival_Prob2 {

    static class Tuple {
        int h;
        int s;
        int e;

        public Tuple(int h, int s, int e) {
            this.h = h;
            this.s = s;
            this.e = e;
        }
    }

    public static void add(int el, PriorityQueue<Integer> primaryMinQueue, PriorityQueue<Integer> secondaryMaxQueue,
                           int[] size, long[] currSum,
                           HashMap<Integer, Integer> removedPrimary, HashMap<Integer, Integer> removedSecondary, int k) {
        if (size[0] < k) {
            primaryMinQueue.add(el);
            currSum[0] += el;
            size[0]++;
        } else {
            int minEl = getMinEl(primaryMinQueue, removedPrimary);
            if (el <= minEl) {
                secondaryMaxQueue.add(el);
            } else {
                primaryMinQueue.poll();
                primaryMinQueue.add(el);
                currSum[0] += el - minEl;
                secondaryMaxQueue.add(minEl);
            }
        }
    }

    private static int getMinEl(PriorityQueue<Integer> primaryMinQueue, HashMap<Integer, Integer> removed) {
        int minEl = primaryMinQueue.peek();
        while (!primaryMinQueue.isEmpty() && removed.containsKey(primaryMinQueue.peek())) {
            removeElementFromQueueAndMap(primaryMinQueue, removed, minEl);
        }
        if (primaryMinQueue.isEmpty()) {
            minEl = -1;
        } else {
            minEl = primaryMinQueue.peek();
        }
        return minEl;
    }

    private static void removeElementFromQueueAndMap(PriorityQueue<Integer> primaryMinQueue, HashMap<Integer, Integer> removed, int minEl) {
        minEl = primaryMinQueue.poll();
        int minFreq = removed.get(minEl);
        if (minFreq == 1) {
            removed.remove(minEl);
        } else {
            removed.put(minEl, minFreq - 1);
        }
    }

    public static void remove(int el, PriorityQueue<Integer> primaryMinQueue, PriorityQueue<Integer> secondaryMaxQueue,
                           int[] size, long[] currSum,
                           HashMap<Integer, Integer> removedPrimary, HashMap<Integer, Integer> removedSecondary, int k) {
        int minEl = getMinEl(primaryMinQueue, removedPrimary);
        if (el >= minEl) {
            if (removedPrimary.containsKey(el)) {
                removedPrimary.put(el, removedPrimary.get(el) + 1);
            } else {
                removedPrimary.put(el, 1);
            }
            if  (!secondaryMaxQueue.isEmpty()) {
//                int topSq = secondaryMaxQueue.poll();
                int topSq = getMinEl(secondaryMaxQueue, removedSecondary);
                secondaryMaxQueue.poll();
                primaryMinQueue.add(topSq);
                currSum[0] += topSq - el;
            } else {
                size[0]--;
                currSum[0] -= el;
            }
        } else {
            if (removedSecondary.containsKey(el)) {
                removedSecondary.put(el, removedSecondary.get(el) + 1);
            } else {
                removedSecondary.put(el, 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int d = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();
            List<Tuple> list = new ArrayList<>();
            for (int  j = 0 ; j < n ; j++) {
                int h = in.nextInt();
                int s = in.nextInt();
                int e = in.nextInt();
                list.add(new Tuple(h, s, e));
            }
            Collections.sort(list, (t1, t2) -> {
                if (t1.s == t2.s) {
                    return t1.e - t2.e;
                } else {
                    return t1.s - t2.s;
                }
            });
            List<Tuple> endList = new ArrayList<>(list);
            Collections.sort(endList, Comparator.comparingInt(t2 -> t2.e));
            long ans = 0;
            int[] size = new int[1];
            HashMap<Integer, Integer> removedPrimary = new HashMap<>();
            HashMap<Integer, Integer> removedSecondary = new HashMap<>();
            long[] currSum = new long[1];
            PriorityQueue<Integer> primaryMinQueue = new PriorityQueue<>();
            PriorityQueue<Integer> secondaryMaxQueue = new PriorityQueue<>(Collections.reverseOrder());
            int posStartList = 0;
            int posEndList = 0;
            for (int j = 1 ; j <= d ; j++) {
                while (posStartList < n && list.get(posStartList).s <= j) {
                    add(list.get(posStartList).h, primaryMinQueue, secondaryMaxQueue, size, currSum, removedPrimary, removedSecondary, k);
                    posStartList++;
                }
                ans = Math.max(ans, currSum[0]);
                while (posEndList < n && endList.get(posEndList).e <= j) {
                    remove(endList.get(posEndList).h, primaryMinQueue, secondaryMaxQueue, size, currSum, removedPrimary, removedSecondary, k);
                    posEndList++;
                }
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
