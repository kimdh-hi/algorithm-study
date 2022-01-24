package com.example.programmers;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/86051
 * 없는 숫자 더하기
 */

public class programmers_22 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        int order = 0;
        Stack<Integer> stack = new Stack<>();
        while (order < progresses.length) {
            for (int i=0;i<progresses.length;i++) {
                if (progresses[i] + speeds[i] >= 100) {
                    if (order == i) {
                        int cnt = 1;
                        order++;
                        while (!stack.empty()) {
                            stack.pop();
                            order++;
                            ++cnt;
                        }
                        answerList.add(cnt);
                    }
                } else {
                    progresses[i] = progresses[i] + speeds[i];
                }
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i=0;i<answer.length;i++) {
            answer[0] = answerList.get(0);
        }
        return answer;
    }
}
