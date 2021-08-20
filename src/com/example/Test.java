package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dp;
    static int N, K;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];
        int w, v;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= K; j++) {
                dp[i][j] = j < w ? dp[i-1][j] : Math.max(v + dp[i - 1][j - w], dp[i - 1][j]);
            }
        }
        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println(dp[N][K]);
    }
}