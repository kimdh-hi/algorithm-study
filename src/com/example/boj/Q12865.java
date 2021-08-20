package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/12865
 * 왜 실패 ..
 */
public class Q12865 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배낭에 담을 수 있는 물품 종류
        int w = Integer.parseInt(st.nextToken()); // 견딜 수 있는 최대 베낭 무게
        int[] dp = new int[w+1];

        Queue<int[]> q = new LinkedList<>();
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            // 가져온 무게부터 베낭에 담아봄
            for (int i=arr[0];i<dp.length;i++) {
                dp[i] = Math.max(dp[i-arr[0]]+arr[1],dp[i]);
            }
        }

        System.out.println(dp[w]);
    }
}
