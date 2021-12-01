package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int maxSum = 0;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    int tmp = arr[i] + arr[j] + arr[k];
                    if (tmp <= m) {
                        maxSum = tmp > maxSum ? tmp : maxSum;
                    }
                }
            }
        }
        System.out.println(maxSum);
    }
}
