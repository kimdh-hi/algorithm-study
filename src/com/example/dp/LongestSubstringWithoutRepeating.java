package com.example.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 투 포인터
 *
 * 문자열에서 중복이 없는 가장 긴 연속된 문자의 개수
 */

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {

        String t1 = "abcabcd";
        String t2 = "pwwkea";

        LongestSubstringWithoutRepeating a = new LongestSubstringWithoutRepeating();
        System.out.println(a.solve1(t2));
    }

    private int solve1(String str) {
        int l=0, r=0, max=0; // 투포인터
        boolean dup = false; // 중복 발생 여부
        Map<Character, Integer> map = new HashMap<>();

        while (r < str.length()) { // 오른쪽 포인터를 문자열 끝까지
            char c = str.charAt(r);
            // key를 문자로 value는 해당 값의 빈도를
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1){ // 빈도 = 2
                dup = true; // 중복 발생
            }
            r++;

            // 중복 발생시 중복이 발생한 위치까지 l을 땡겨야 함 (이전 문자를 무시하도록)
            while(dup) {
                Integer cnt = map.get(str.charAt(l));
                if(cnt>1) { // 중복을 발생시킨 문자발견
                    dup = false; // 중복체크 off
                }
                map.put(str.charAt(l), 0); // 중복이 발생한 문자까지 빈도를 0으로 초기화
                l++; // 왼쪾 포인터를 오른쪽으로 이동
            }

            max = Math.max(max, r-l);
        }
        return max;
    }
}
