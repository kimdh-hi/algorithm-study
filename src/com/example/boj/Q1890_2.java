package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1890
 * 점프
 */

public class Q1890_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] m = new int[n+1][n+1];
        long[][] dp = new long[n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=n;j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1; // 출발점

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                int jump = m[i][j]; // 해당 좌표에서의 점프
                if (jump == 0) break; // 0은 종착점
                // 오른쪽으로 점프가능한지 (범위 안에 있는지) 확인
                // 가능하다면 현재 좌표의 경유횟수를 dp의 점프 후 좌표에 누적
                // dp[i][j] 는 i,j 좌표의 경유 횟수임
                // 점프가 가능하더라도 현재 좌표가 다른 좌표로부터 경유되지 않는다면 경로로 누적되지 않음.
                if (j+jump <= n) dp[i][j+jump] += dp[i][j];
                // 아래쪽으로 점프가 가능한지 확인
                if (i+jump <= n) dp[i+jump][j] += dp[i][j];
            }
        }
        System.out.println(dp[n][n]);
    }

//    public static void print(long[][] dp, int n) {
//        for(int i=1;i<=n;i++) {
//            for(int j=1;j<=n;j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("=========");
//    }
}
