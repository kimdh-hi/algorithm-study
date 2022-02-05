package com.example.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2 {

    static Queue<Pos> queue = new LinkedList<>();
    static int[][] check;
    static int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] box = new int[m][n];
        check = new int[m][n];

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j=0;j<n;j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) queue.offer(new Pos(i,j));
            }
        }

        Q2 q = new Q2();
        int answer = q.bfs(box, m, n);
        System.out.println(answer);

        for (int i=0;i<check.length;i++) {
            for (int j=0;j<check[i].length;j++) {
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int bfs(int[][] box, int m, int n) {
        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            for (int[] d : dir) {
                int nx = pos.x + d[0];
                int ny = pos.y + d[1];
                if (0<=nx && nx<m && 0<=ny && ny<n && box[nx][ny] == 0) {
                    check[nx][ny] = check[pos.x][pos.y] + 1;
                    box[nx][ny] = 1;
                    queue.offer(new Pos(nx, ny));
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i=0;i<check.length;i++) {
            for (int j=0;j<check[i].length;j++) {
                result = Math.max(result, check[i][j]);
            }
        }
        return result;
    }

    static class Pos{
        public final int x;
        public final int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
