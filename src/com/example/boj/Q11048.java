package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11048
 * 이동하기
 *
 * 매 입력마다 왼쪽, 위쪽, 대각방향에서의 최대값을 더해줘야 함
 */

public class Q11048 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n+1][m+1];

        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=m;j++) {
                int v = Integer.parseInt(st.nextToken());
                maze[i][j] = Math.max(maze[i-1][j], Math.max(maze[i][j-1], maze[i-1][j-1])) + v;
            }
        }
        System.out.println(maze[n][m]);

    }
}
