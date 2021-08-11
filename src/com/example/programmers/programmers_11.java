package com.example.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12915
 * 문자열 내 마음대로 정렬하기
 */
public class programmers_11 {
    public static void main(String[] args) {
        String[] t1 = {"sun", "bed", "car"};
        programmers_11 a = new programmers_11();
        a.solution(t1, 1);
        for (String s : t1) {
            System.out.println(s);
        }
    }
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) != s2.charAt(n)) {
                    return s1.charAt(n) - s2.charAt(n);
                } else {
                    return s1.compareTo(s2);
                }
            };
        });
        return strings;
    }
}
