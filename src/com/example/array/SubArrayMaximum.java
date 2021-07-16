package com.example.array;

/**
 * 정수 배열에서 연속된 서브어레이의 최대값
 * dp를 이용한 풀이
 */

public class SubArrayMaximum {

    public static void main(String[] args) {
        int[] t1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        SubArrayMaximum a = new SubArrayMaximum();

        System.out.println(a.solve(t1));
    }

    private int solve(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int res = 0;
        for (int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
