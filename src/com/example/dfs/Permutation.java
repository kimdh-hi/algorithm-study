package com.example.dfs;

/**
 * 중복 없는 순열
 */

public class Permutation {

    int cnt =0;

    public static void main(String[] args) {
        Permutation a = new Permutation();
        System.out.println(a.solve(3,2));
    }

    private int solve(int n, int m) {
        int[] res = new int[m];
        int[] visited = new int[n+1];
        return dfs(res, visited, n, m, 0);
    }

    public int dfs(int[] res, int[] visited, int n, int m, int l) {
        if (l == m) {
            for (int i=0;i<l;i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
            cnt++;
        } else {
            for (int i=1;i<=n;i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    res[l] = i;
                    dfs(res, visited, n, m, l+1);
                    visited[i] = 0;
                }
            }
        }
        return cnt;
    }
}
