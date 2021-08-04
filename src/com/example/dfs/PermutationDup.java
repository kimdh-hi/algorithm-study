package com.example.dfs;

/**
 * 중복순열
 */
public class PermutationDup {

    int cnt = 0;
    public static void main(String[] args) {
        int tn1=3, tm1=2;
        PermutationDup a = new PermutationDup();
        System.out.println(a.solve(tn1, tm1));

    }
    private int solve(int n, int m) {
        int[] visited = new int[n];
        int[] res = new int[m];
        return dfs(res, 0, n, m);
    }

    public int dfs(int[] res, int l, int n, int m) {
        if (l==m) {
            for (int i=0;i<l;i++) {
                System.out.print(res[i]);
            }
            System.out.println();
            cnt++;
        } else {
            for (int i=1; i<=n;i++) {
                res[l] = i;
                dfs(res, l+1, n, m);
            }
        }
        return cnt;
    }
}
