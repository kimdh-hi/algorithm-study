package com.example.programmers;

import com.example.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class programmers_5 {

    List<int[]> lists = new ArrayList<>();
    int cnt = 0;

    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        Arrays.sort(nums);
        programmers_5 t = new programmers_5();
        t.solution(nums);
    }
    public int solution(int[] nums) {
        int answer = -1;
        int[] dp = new int[3];
        dfs(nums, dp, 0, 0);
        System.out.println("cnt = " + cnt);
        return 0;
    }

    public void dfs(int[] nums, int[] dp, int start, int l) {
        if (l == 3) {
            // 3개 조합
            int sum = 0;
            for (int num : dp) {
                sum += num;
            }
            for (int i=2;i<sum;i++) {
                if (sum % i == 0) {
                    return;
                }
            }
            cnt++;
        } else {
            for (int i=start; i<nums.length;i++) {
                dp[l] = nums[i];

                dfs(nums, dp, i+1, l+1);
            }
        }
    }
}
