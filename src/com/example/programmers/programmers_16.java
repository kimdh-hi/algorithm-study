package com.example.programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 * 타겟넘버
 */

public class programmers_16 {
    public static void main(String[] args) {
        int[] t1 = {1, 1, 1, 1, 1};
        programmers_16 a = new programmers_16();
        a.solution(t1, 3);
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    public int dfs(int[] numbers, int target, int depth, int sum) {
        if (numbers.length == depth) {
            return sum == target ? 1 : 0;
        } else {
            return dfs(numbers, target, depth+1, sum+numbers[depth]) +
                    dfs(numbers, target, depth+1, sum-numbers[depth]);
        }
    }
}
