package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10884 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][10];
        for(int i=0;i<10;i++) {
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++) {
            for(int j=1;j<10;j++) {
                if (j==1) dp[i][j] = dp[i-1][j]+1;
                else if (j==9) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 1000000000;
            }
        }
//        for (int i=1;i<=n;i++) {
//            for (int j=1;j<10;j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        int res = 0;
        for (int i=1;i<10;i++) {
            res += dp[n][i] % 1000000000;
        }
        System.out.println(res%1000000000);
    }
}
