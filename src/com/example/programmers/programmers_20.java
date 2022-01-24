package com.example.programmers;

import java.util.HashMap;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/86051
 * 없는 숫자 더하기
 */

public class programmers_20 {

    class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            int[] nums = new int[]{0,1,2,3,4,5,6,7,8,9};
            for (int i: numbers) {
                nums[i] = 0;
            }
            for (int n: nums) {
                answer += n;
            }
            return answer;
        }
    }
}
