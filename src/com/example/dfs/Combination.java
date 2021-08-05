package com.example.dfs;

public class Combination {

    int cnt = 0;

    public static void main(String[] args) {

        Combination a = new Combination();
        int n=29,m=13;
        System.out.println(a.solve(n, m));
    }

    private int solve(int n, int m) {
        int[] res = new int[m];

        return dfs(res, n, m, 0, 1);
    }

    public int dfs(int[] res, int n, int m, int l, int s) {
        if (l == m) {
//            for (int i=0;i<m;i++) {
//                System.out.print(res[i] + " ");
//            }
            cnt++;
            //System.out.println();
        } else {
            for (int i=s; i<=n; i++) {
                res[l] = i;
                dfs(res, n, m, l+1, i+1);
            }
        }
        return cnt;
    }
}
