package com.example.programmers;

/**
 * 프로그래머스 - 폰켓몬
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 */

import java.util.HashSet;
import java.util.Set;

public class programmers_6 {

    public static void main(String[] args) {

    }

    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() >= len/2) {
            answer = len/2;
        } else {
            answer = set.size();
        }
        return answer;
    }

}
