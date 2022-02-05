package com.example.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_17 {

    public static void main(String[] args) {
        String[][] t = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        String[] strings = t[0];
        programmers_17 a = new programmers_17();
        int[] solution = a.solution(t);
        for (int i : solution) {
            System.out.print(i);
        }
    }
    int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i=0;i<5;i++) {
            answer[i] = check(places[i]); // 한 개 대기실
        }
        return answer;
    }

    public int check(String[] room) {
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                if (room[i].charAt(j) == 'P') { // 사람이 앉은 곳부터 bfs 시작
                    boolean res = bfs(room, i, j);
                    if (!res) return 0;
                }
            }
        }
        return 1;
    }
    public boolean bfs(String[] room, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[5][5];
        q.offer(new int[]{i,j});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];

            visited[x][y] = 1;
            for (int k=0;k<4;k++) {
                int nx = x + d[k][0];
                int ny = y + d[k][1];
                int m_dis = Math.abs(nx-i) + Math.abs(ny-j);
                if (nx>=0 && nx<5 && ny>=0 && ny<5 && visited[nx][ny]!=1 && m_dis<=2) {
                    if (room[nx].charAt(ny) == 'P') return false;
                    if (room[nx].charAt(ny) == 'X') continue;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return true;
    }
}
