package com.example.programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 * 메뉴 리뉴얼 2021 KAKAO BLIND RECRUITMENT
 */

import java.util.*;
public class programmers_18 {

    public static void main(String[] args) {
        programmers_18 a = new programmers_18();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        a.solution(orders, course);

    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        int ans_idx = 0;
        for (int i=0; i<course.length;i++) {
            Map<String, Integer> map = new HashMap<>();
            for (int j=0; j<orders.length;j++) {
                map = dfs(orders[j], "", course[i], 0, 0, map);
            }
            // 최대값 찾기
            int max = -1;
            for(String key : map.keySet()) {
                max = Math.max(max,map.get(key));
            }
            for (String key : map.keySet()) {
                if (map.get(key) >= 2)
                    if (max == map.get(key)) answer.add(key);
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer.toArray(new String[answer.size()]);
    }
    public Map<String, Integer> dfs(String order, String tmp, int max, int level, int start, Map<String,Integer> map) {
        if (level == max) {
            char[] carr = tmp.toCharArray();
            Arrays.sort(carr);
            tmp = String.valueOf(carr);
            map.put(tmp, map.getOrDefault(tmp,Integer.valueOf(0))+1);
        } else {
            for (int i=start; i<order.length(); i++) {
                dfs(order, tmp+String.valueOf(order.charAt(i)), max, level+1, i+1, map);
            }
        }
        return map;
    }
}
