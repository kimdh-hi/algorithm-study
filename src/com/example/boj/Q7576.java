package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {

    static int N, M;
    static int[][] box;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] dir = new int[][]{{1,0}, {0,-1}, {-1,0}, {0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<N;j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<M;i++) {
            for (int j=0;j<N;j++) {
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i=0;i<4;i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && box[nx][ny] == 0) {
                    box[nx][ny] = box[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        boolean flag = false;
        int result = -1;
        for (int i=0;i<M;i++) {
            for (int j=0;j<N;j++) {
                if (box[i][j] == 0) {
                    result = -1;
                    flag = true;
                    break;
                } else {
                    result = Math.max(result, box[i][j]);
                }
            }
            if (flag) break;
        }
        if (result > -1) System.out.println(result-1);
        else System.out.println(result);
    }
}
