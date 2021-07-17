package com.example.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 밑면, 높이 무게 순으로 입력
 *
 * 입력된 순서를 유지해야 함
 * 반드시 더 넓은 밑면의 돌 위에 적은 밑면의 돌이 쌓여야 함함 */
public class LIS2 {

    public static void main(String[] args) {
        List<Integer[]> t = new ArrayList<>();
        t.add(new Integer[]{25,3,4});
        t.add(new Integer[]{4,4,6});
        t.add(new Integer[]{9,2,3});
        t.add(new Integer[]{16,2,5});
        t.add(new Integer[]{1,5,2});

        LIS2 a = new LIS2();

        System.out.println(a.solve(t));
    }

    private int solve(List<Integer[]> rocks) {

        int n = rocks.size();

        int[] dp = new int[n];
        dp[0] = rocks.get(0)[1];
        int res = 0;
        int max_h = 0;
        for (int i=1; i<n; i++) {
            max_h = 0;
            for (int j=i-1; j>=0; j--) {
                if (rocks.get(i)[0] < rocks.get(j)[0] && rocks.get(j)[1] > max_h) {
                    max_h = dp[j];
                }
            }
            dp[i] = max_h + rocks.get(i)[1];
            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }
}
