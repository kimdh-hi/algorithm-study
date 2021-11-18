//package com.example.dp;
//
//import java.util.*;
//
///**
// * 4 11
// * 5 12
// * 3 8
// * 6 14
// * 4 8
// */
//public class KnapsackBack {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] dp = new int[m+1];
//        List<List<Integer>> lists = new ArrayList<>();
//        for (int i=0;i<n;i++) {
//            int w = sc.nextInt();
//            int v = sc.nextInt();
//            lists.add(List.of(w,v));
//        }
//
//        KnapsackBack a = new KnapsackBack();
//        System.out.println(a.solve(lists, dp));
//    }
//    private int solve(List<List<Integer>> lists, int[] dp) {
//        for (int i=0;i<lists.size();i++) {
//            for (int j=lists.get(i).get(0);j<dp.length;j++) {
//                dp[j] = Math.max(dp[j-lists.get(i).get(0)]+lists.get(i).get(1), dp[j]);
//            }
//        }
//        return dp[dp.length-1];
//    }
//}
