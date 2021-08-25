package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1890 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] m = new int[n][n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int res = 0;
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            if(m[x][y] == 0) {
                res++;
                continue;
            }
            int jump = m[x][y];
            int nx = x+jump;
            int ny = y+jump;

            if (nx>=0 && nx<n) q.offer(new int[]{nx, y});
            if (ny>=0 && ny<n) q.offer(new int[]{x, ny});

        }
        System.out.println(res);
    }
}
