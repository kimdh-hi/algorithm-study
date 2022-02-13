package com.example.boj;

import java.io.*;
import java.util.StringTokenizer;

public class Q1182 {

    static BufferedWriter bw;
    static BufferedReader br;
    static int N, S;
    static int[] nums;
    static int[] subset; // DFS 탐색하며 부분집합 구성을 시도할 배열
    static int result = 0;
    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        subset = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0;i<N;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0); // DFS 호출

        System.out.println(result);
    }

    static void dfs(int depth, int start) {
        // 1개 이상 N개 이하 부분집합이 만들어진 경우
        if (depth >= 1 && depth <= N) {
            int sum = 0;
            for (int i=0;i<N;i++) {
                sum += subset[i];
            }
            // 부분집합의 합이 S인지 확인한다.
            if (sum == S) {
                result++;
            }
        }

        for (int i=start; i<N; i++) {
            subset[i] = nums[i]; // 부분집합 구성 시도
            dfs(depth+1, i+1);
            subset[i] = 0; // 한 쪽 탐색 후 돌아오면서 해당 자리에 다른 부분집합이 쓰일 수 있도록 초기화한다.
        }
    }
}
