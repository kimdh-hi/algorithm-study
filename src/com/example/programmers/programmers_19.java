package com.example.programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 * 124 나라의 숫자
 */

import java.util.*;

public class programmers_19 {
    class Solution {
        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                int a = n%3; // 3진법 형태이므로 3으로 나눈 나머지 계산
                n/=3;

                if (a == 0) { // 3의 배수의 경우 4가 붙어야 한다.
                    sb.append("4");
                    --n;
                } else { // 3의 배수가 아닌 경우 나머지를 그대로 붙여준다.
                    sb.append(String.valueOf(a));
                }
            }
            // 역순으로 출력
            return sb.reverse().toString();
        }
    }
}
