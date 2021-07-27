package com.example.bfs;

import java.util.*;

public class MaxOfIsland {

    public static void main(String[] args) {
        MaxOfIsland a = new MaxOfIsland();
        int[][] t1 = new int[][] {
                {1,1,0,1,1},
                {0,1,1,0,0},
                {0,0,0,0,0},
                {1,1,0,1,1},
                {1,0,1,1,1},
                {1,0,1,1,1}
        };
        System.out.println(a.solve(t1));
    }

    private int solve(int[][] map) {
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};
        Queue<Integer[]> q = new LinkedList<>();
        int res = 0;
        int n = map.length;
        int m = map[0].length;
        for (int i=0;i<n;i++) {
            int cnt = 0;
            for (int j=0;j<m;j++) {
                if (map[i][j] == 1) {
                    q.offer(new Integer[]{i,j});
                    while(!q.isEmpty()) {
                        Integer[] p = q.poll();
                        map[p[0]][p[1]] = -1;
                        cnt++;
                        for (int k=0; k <4; k++) {
                            int nx = p[0] + dx[k];
                            int ny = p[1] + dy[k];
                            if(nx >= 0 && nx < n && ny >=0 && ny < m && map[nx][ny] == 1) {
                                q.offer(new Integer[]{nx, ny});
                            }
                        }
                    }
                    for (int a=0;a<n;a++) {
                        for (int b=0;b<m;b++) {
                            System.out.print(map[a][b] + " ");
                        }
                        System.out.println();
                    }
                    res = Math.max(res, cnt);
                    System.out.println("res = " + res);
                    cnt=0;
                }
            }
        }
        return res;
    }
}
