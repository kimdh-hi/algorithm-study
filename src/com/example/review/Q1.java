package com.example.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] h = new int[n];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            h[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(n, m, h));
    }

    static public int solve(int n, int m, int[] h) {
        Arrays.sort(h);

        int l = h[0];
        int r = h[n-1];
        int answer = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = (int)((l + r)/2);
            int curr = h[0];
            int cnt = 1;
            for (int i=1;i<h.length;i++) {
                if (h[i] - curr >= mid) {
                    ++cnt;
                    curr = h[i];
                }
            }
            if (cnt>=m) {
                answer = Math.max(answer, mid);
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return answer;
    }
}
