package com.example.programmers;

import java.util.*;

public class Programmers_19 {

    public static void main(String[] args) {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k=2;

        Programmers_19 p = new Programmers_19();
        int[] result = p.solution(id_list, report, k);

        for(int r: result) {
            System.out.print(r  + " ");
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer;

        Map<String, Integer> reportCountLog = new HashMap<>(); // 자신이 신고한 횟수
        Map<String, Set<String>> reportPersonLog = new HashMap<>(); // 자신을 신고한 사용자들의 ID

        for (String id: id_list) {
            reportCountLog.put(id, 0);
            reportPersonLog.put(id, new HashSet<>());
        }

        for (String r: report) {
            String from = r.split(" ")[0];
            String to = r.split(" ")[1];
            reportPersonLog.get(to).add(from); // 자신을 신고한 사용자들 ID 초기화
        }

        for (String r: reportPersonLog.keySet()) {
            Set<String> reporters = reportPersonLog.get(r); // 신고한 사람들
            if (reporters.size() >= k) { // 신고한 사람들이 k 보다 큰 경우 (set이기 때문에 신고한 사람==신고횟수임)
                for (String reporter: reporters) {
                    Integer count = reportCountLog.get(reporter);
                    reportCountLog.put(reporter, count+1);
                }
            }
        }

        answer = new int[id_list.length];
        for(int i=0;i<answer.length;i++) {
            answer[i] = reportCountLog.get(id_list[i]);
        }

        return answer;
    }
}
