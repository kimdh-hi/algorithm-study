package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14501
 * 퇴사
 */
public class Q14501_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] t = new int[n+1];
        int[] p = new int[n+1];
        int[] dp = new int[n+2];

        // 날짜와 인덱스를 갖게 하기 위해 1부터 시작
        for (int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken()); // 예약접수시 상담완료까지 걸리는 시간
            p[i] = Integer.parseInt(st.nextToken()); // 상담완료시 수익
        }

        for(int i=n;i>0;i--) {
            int day = i+t[i]; // 현재 날짜에서 상담완료까지의 시간을 더한 기간

            // 상담완료시 퇴직날짜를 넘어서는 경우
            // N+1이 퇴직일자이므로 n+1과 비교
            if (day > n+1) {
                // 앞서 구해진 최대수익을 그대로 가져옴
                // 현재 날짜는 예약 불가하지만 앞선 날짜에서 상담가능한 날짜가 있을 수 있기 때문
                dp[i] = dp[i+1];
            } else { // 상담 예약이 가능한 경우
                // dp[day] : 현재 날짜에서 상담완료 후의 최대수익
                // p[i] : 현재 날짜의 수익
                // dp[day] + p[i] : 현재 날짜로부터 상담완료 후의 최대수익 + 현재 날짜의 수익
                dp[i] = Math.max(dp[day] + p[i], dp[i+1]);
                // dp[i+1] : 앞선 날짜의 최대수익
            }
        }

        System.out.println(dp[1]);
    }
}
