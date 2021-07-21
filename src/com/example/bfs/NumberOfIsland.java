package com.example.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    int[] d_x = new int[]{1,0,-1,0};
    int[] d_y = new int[]{0,-1,0,1};

    public static void main(String[] args) {

        int[][] t1 = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int[][] t2 = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };
        int[][] t3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] t4 = new int[][]{
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };


        NumberOfIsland a = new NumberOfIsland();
        int result1 = a.solve(t1);
        int result2 = a.solve(t2);
        int result3 = a.solve(t3);
        int result4 = a.solve(t4);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
        System.out.println("result4 = " + result4);
    }

    private int solve(int[][] map) {

        int n = map.length;
        int m = map[0].length;
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (map[i][j] == 1) {
                    cnt++;
                    q.offer(new int[]{i,j});
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        map[p[0]][p[1]] = -1;
                        for (int k=0;k<4;k++) {
                            int nx = p[0] + d_x[k];
                            int ny = p[1] + d_y[k];
                            if (nx > 0 && nx < n && ny > 0 && ny < m && map[nx][ny] == 1) {
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
