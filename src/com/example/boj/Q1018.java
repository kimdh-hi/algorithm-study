package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1018
 * 체스판 다시 칠하기
 */

public class Q1018 {

    static int res = Integer.MAX_VALUE;
    static boolean[][] map;
    static final int RANGE = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];

        for(int i=0;i<n;i++) {
            String row = br.readLine();
            for(int j=0;j<m;j++) {
                if(row.charAt(j) == 'W') map[i][j] = true;
                else map[i][j] = false;
            }
        }

        //print(map);
        int r_start = 0;
        int c_start = 0;
        boolean r_flag = true;
        boolean c_flag = true;
        while (true) {
            check(r_start, c_start);

            if (r_start < n-RANGE) {
                r_start++;
            } else {
                if (c_start < m-RANGE) {
                    c_start++;
                    r_start = 0;
                } else {
                    break;
                }
            }
        }
        System.out.println(res);
    }

    static void check(int r_idx, int c_idx) {

        boolean flag = map[r_idx][c_idx];
        int cnt = 0;
        for(int i=r_idx; i<r_idx+RANGE; i++) {
            for (int j=c_idx; j<c_idx+RANGE; j++) {
                if (map[i][j] != flag) {
                    cnt++;
                }

                flag = !flag;
            }
            flag = !flag;
        }
        cnt = Math.min(cnt, RANGE*RANGE-cnt);
        res = Math.min(res, cnt);
    }

    static void print(boolean[][] map) {
       for(int i=0;i<map.length;i++) {
           for (int j=0;j<map[i].length;j++) {
               System.out.print(map[i][j] + " ");
           }
           System.out.println();
       }
    }
}
/**
 * 반례
 * 8 8
 * BBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 */
