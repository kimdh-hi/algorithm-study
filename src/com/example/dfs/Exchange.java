package com.example.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 동전교환
 */

public class Exchange {

    static int cnt = 0;
    static int res = 9999999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<t;i++) {
            list.add(sc.nextInt());
        }
        int target = sc.nextInt();

        System.out.println(solve(t, list, target));
    }

    public static int solve(int n, List<Integer> list, int target) {
        list.sort((a,b)->b-a);

        return dfs(n, list, 0, target, 0);
    }
    public static int dfs(int n, List<Integer> list, int l, int target, int sum) {
        if(l > res) return 0;
        if(sum > target) return 0;
        if (sum == target) {
            res = Math.min(res, l);
        }
        else {
            for (int i=0;i<n;i++) {
                dfs(n, list, l+1, target, sum+=list.get(i));
            }
        }
        return res;
    }
}
