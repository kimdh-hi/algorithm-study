package com.example.bfs;

/**
 * 미로 bfs
 *
 * 시작점과 도착점이 주어질 때 탈출가능하다면 true 불가능하다면 false
 */

import java.util.LinkedList;
import java.util.Queue;

public class MazeBfs {

    int[][] d = {{1,0},{0,-1},{-1,0},{0,1} };
    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        MazeBfs a = new MazeBfs();
        boolean result = a.solve(maze, new int[]{0,4}, new int[]{4,4});

        System.out.println("result = " + result);
    }

    public boolean solve(int[][] maze, int[] start, int[] dest) {

        int n = maze.length;
        int m = maze[0].length;

        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0],start[1]});
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            visited[x][y] = 1;
            for (int i=0;i<4;i++) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];
                if (nx>=0 && nx<n && ny>=0 && ny<m && maze[nx][ny] != 1 && visited[nx][ny] != 1) {
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        if (visited[n-1][m-1] == 0) return false;
        else return true;
    }
}
