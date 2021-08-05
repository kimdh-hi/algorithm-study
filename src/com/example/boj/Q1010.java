package com.example.boj;

import java.util.Scanner;

public class Q1010 {

    static int cnt = 0;
    static int[][] dp = new int[30][30];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i=0;i<t;i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(solve(n, m));
        }
    }
    public static int solve(int n, int m) {
        int[] res = new int[n];
        return dfs(res, n, m, 0, 1);
    }

    public static int dfs(int[] res, int n, int m, int level, int start) {
        if (level == n) {
            cnt++;
        } else {
            for (int i=start; i<=m; i++) {
                res[level] = i;
                dfs(res, n, m, level+1, i+1);
            }
        }
        return cnt;
    }


}
