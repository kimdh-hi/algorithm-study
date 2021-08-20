package com.example.boj;

import java.io.*;
import java.util.StringTokenizer;

public class Q18229 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        boolean flag = true;
        int[][] arr = new int[n][m];

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (j - 1 >= 0) {
                    arr[i][j] += arr[i][j - 1];
                }
                if (arr[i][j] >= target) {
                    sb.append(i+1 + " " + (j+1));
                    System.out.println(sb);
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }
        br.close();
    }
}
