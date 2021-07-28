package com.example.dfs;

public class MaxOfIsland {

    int[] dx = new int[]{1,0,-1,0};
    int[] dy = new int[]{0,1,0,-1};

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

        int n = map.length;
        int m = map[0].length;
        int res = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (map[i][j] == 1) {
                    int cnt = dfs(map, i, j, 0);
                    res = Math.max(cnt, res);

                }
            }
        }
        return res;
    }

    int dfs(int[][] map, int x, int y, int cnt) {
        if (x<0 || x>=map.length  || y<0 || y>=map[0].length || map[x][y] == 0) return cnt;
        map[x][y] = 0;
        cnt++;
        for (int i=0;i<4;i++) {
            cnt = dfs(map, x+dx[i], y+dy[i], cnt);
        }
        return cnt;
    }

}
