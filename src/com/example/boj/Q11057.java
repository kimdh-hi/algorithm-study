package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][10];
        for(int i=1;i<=n;i++) {
            dp[i][0] = 1;
        }
        for(int i=1;i<10;i++) {
            dp[1][i] = 1;
        }
        if( n > 1) {
            for (int i = 1; i < 10; i++) {
                dp[2][i] = i + 1;
            }
        }

        for (int i=3;i<=n;i++) {
            for (int j=1;j<10;j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j])% 10007;
            }
        }
        int res = 0;
        for (int i=0;i<10;i++) {
            res += dp[n][i];
        }

        System.out.println(res%10007);
    }
}
