package com.example.dp;

/**
 * 최대 길이 수열 구하기
 */

public class LIS {

    public static void main(String[] args) {
        LIS lis = new LIS();

        int[] t1 = new int[]{5,3,7,8,6,2,9,4};
        int result1 = lis.solve(t1);

        System.out.println("result1 = " + result1);
    }

    private int solve(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 0;
        int max = 0;
        for(int i=1;i<len;i++) {
            max = 0;
            for(int j=i-1; j>=0; j--) {
                if (arr[i] > arr[j] && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
