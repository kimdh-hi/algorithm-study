package com.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibonacciMemorization {

    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        fib(n,' ');

        System.out.println(dp[n]);
    }
    public static int fib(int n, char c) {
        System.out.println("n, c = " + n + c);
        if (n == 1) return dp[n]=1;
        else if (n==2) return dp[n]=1;
        else if (dp[n] > 0) return dp[n];
        else
            return dp[n] = fib(n-1, 'L') + fib(n-2, 'R');
    }
}