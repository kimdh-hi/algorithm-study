package com.example.programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12916
 * 문자열 내 p와 y의 개수
 */

public class programmers_12 {
    public static void main(String[] args) {
        String s1 ="pPoooyY";
        programmers_12 a = new programmers_12();
        boolean res = a.solution(s1);
        System.out.println("res = " + res);
    }
    boolean solution(String s) {
        boolean answer = true;
        int cnt=0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'p': cnt++; break;
                case 'P': cnt++; break;
                case 'y': cnt--; break;
                case 'Y': cnt--; break;
                default: break;
            }
        }

        return cnt==0 ? true : false;
    }
}
