package com.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 냅색 알고리즘
 * 최대점수 구하기
 */

public class MaximumPoint {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[m+1];
        List<int[]> list = new ArrayList<>();
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b});
        }

        for(int i=0;i<list.size();i++) {
            int[] tmp = list.get(i);
            for (int j=tmp[1];j<=m;j++) {

                dp[j] = Math.max(dp[j-tmp[1]] + tmp[0], dp[j]);
            }
        }
        for (int i=0;i<=m;i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        System.out.println(dp[m]);
    }
}
