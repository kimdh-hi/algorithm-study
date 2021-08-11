package com.example.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12906
 * 같은 숫자는 싫어
 */

public class programmers_10 {
    public static void main(String[] args) {
        int[] t = {1,1,3,3,0,1,1};
        programmers_10 a = new programmers_10();
        a.solution(t);
    }
    public int[] solution(int []arr) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        int cur = arr[0];
        for (int i=1;i<arr.length;i++) {
            if (arr[i] != cur) {
                list.add(arr[i]);
                cur = arr[i];
            }
        }
        answer = new int[list.size()];
        for (int i=0; i<list.size();i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
