package com.example.dfs;

public class WordSearch {

    int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";

        WordSearch a = new WordSearch();
        System.out.println(a.solve(word, grid));
    }

    private boolean solve(String target, char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (dfs(grid, visited, i, j, 0, target))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, int[][] visited, int x, int y, int tidx, String target) {
        if (tidx == target.length()) return true; // target문자열의 길이만큼 탐색을 했다면 true
        if (x<0 || x>=grid.length || y<0 || y>=grid[0].length) return false; // 범위 체크
        if (visited[x][y] == 1) return false; // 접근되었는지 체크
        if (grid[x][y] != target.charAt(tidx)) return false; // target문자와 같은지 체크
        visited[x][y] = 1; // 위 if문을 모두 통과했다면 접근가능한 인덱스이므로 접근 체크
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (dfs(grid, visited, nx, ny, tidx+1, target)) {
                return true;
            }
        }
        visited[x][y] = 0; // 돌아오면서 접근되었던 인덱스 원복
        return false;
    }
}
