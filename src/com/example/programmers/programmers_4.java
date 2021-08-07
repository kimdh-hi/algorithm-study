package com.example.programmers;

/**
 * 2021 카카오 채용연계형 인턴십 - 숫자 문자열과 영단어
 * https://programmers.co.kr/learn/courses/30/lessons/81301
 */

import java.util.HashMap;
import java.util.Map;

public class programmers_4 {

    public static void main(String[] args) {
        String t1 = "one4seveneight";
        String t2 = "23four5six7";

        programmers_4 t = new programmers_4();
        System.out.println(t.solution(t2));
    }
    public int solution(String s) {
        StringBuilder sb_answer = new StringBuilder();
        Map<String,String> map = new HashMap<>();

        map.put("zero","0");
        map.put("one", "1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six", "6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            // 완전한 숫자형태 문자가 발견된 경우 (map에서 찾아서 삽입)
            if (map.containsKey(sb.toString())) {
                sb_answer.append(map.get(sb.toString()));
                sb = new StringBuilder();
            }
            // 숫자인 경우 (그대로 삽입)
            if ((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57 ) {
                sb_answer.append(s.charAt(i));
            }
            // 문자이지만 완전한 숫자형태 문자를 갖지 못한 경우
            else {
                sb.append(s.charAt(i));
                System.out.println("sb.toString() = " + sb.toString());
            }
        }
        if (map.containsKey(sb.toString())) {
            sb_answer.append(map.get(sb.toString()));
        }
        //System.out.println(sb_answer.toString());
        return Integer.parseInt(sb_answer.toString());
    }
}
