package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9461 {
    static final int SIZE = 101;
    static long[] arr = new long[SIZE];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i=0;i<SIZE; i++) {
            arr[i] = -1;
        }

        for (int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;

            System.out.println(dp(n));
        }
    }

    static long dp(int n) {
        if (arr[n] == -1) {
            arr[n] = dp(n-2) + dp(n-3);
        }
        return arr[n];
    }
}
