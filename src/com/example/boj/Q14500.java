package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14500
 * 테트로미노
 */

public class Q14500 {
    static int[][] arr;
    static int[][] visited;
    static int res;
    static int[][] dir = new int[][] {{0,-1}, {0,1}, {1,0}, {-1,0}};
    // 'ㅜ', 'ㅏ' ,'ㅗ', 'ㅓ' 가장 왼쪽 좌표를 기준으로 함
    static int[][] ex = new int[][] {{0,0,0,1}, {0,1,2,1}, {0,0,0,-1}, {0,-1,0,1}};
    static int[][] ey = new int[][] {{0,1,2,1}, {0,0,0,1}, {0,1,2,1}, {0,1,1,1}};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                visited[i][j] = 1;
                dfs(i,j,arr[i][j],1);
                visited[i][j] = 0;

                exCheck(i,j); // 'ㅜ', 'ㅗ' ,'ㅏ', 'ㅓ' 처리
            }
        }
        System.out.println(res);
    }
    public static void dfs(int x, int y, int sum, int depth) {
        if (depth >= 4) {
            res = Math.max(sum, res);
            return;
        } else {
            for (int i=0;i<4;i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (0<=nx && nx<arr.length && 0<=ny && ny<arr[0].length) {
                    if (visited[nx][ny] != 1) {
                        visited[nx][ny] = 1;
                        dfs(nx, ny, sum+arr[nx][ny], depth+1);
                        visited[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public static void exCheck(int x, int y) {
        int nx=0, ny=0;
        for (int i=0;i<4;i++) {
            boolean flag = true;
            int sum = 0;
            for (int j=0;j<4;j++) {
                nx = x + ex[i][j];
                ny = y + ey[i][j];

                if (nx<0 || nx>=arr.length || ny<0 || ny>=arr[0].length) {
                    flag = false; break;
                }

                sum += arr[nx][ny];
            }
            if (flag) res = Math.max(res, sum);
        }
    }
}
