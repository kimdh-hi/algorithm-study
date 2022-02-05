package com.example.programmers;


import java.util.*;

public class programmers_25 {

    public static void main(String[] args) {
        int[] grade = {3, 2, 1, 2};
        programmers_25 a = new programmers_25();

        int[] result = a.solution(grade);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] grade) {
        int len = grade.length;
        int[] answer = new int[len];

        // 점수를 key값으로 하고 자신의 번호를 value로 하는 map
        // 동일 점수에 대한 처리를 한 번에 하기 위함
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < grade.length; i++) {
            List<Integer> list = map.getOrDefault(grade[i], new ArrayList<>());
            list.add(i);
            map.putIfAbsent(grade[i], list);
        }

        Map<Integer, List<Integer>> sortedMap = sortMapByKey(map);

        int rank = 1;
        for (List<Integer> numberList : sortedMap.values()) {
            for (int i = 0; i < numberList.size(); i++) {
                answer[numberList.get(i)] = rank;
            }
            // 동일 순위에 대한 처리를 위해 현재 점수의 학생 수만큼 다음 순위 증가
            rank += numberList.size();
        }

        return answer;
    }

    // 점수를 기준으로 map 정렬
    private Map<Integer, List<Integer>> sortMapByKey(Map<Integer, List<Integer>> map) {
        LinkedList<Map.Entry<Integer, List<Integer>>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (a, b) -> b.getKey().compareTo(a.getKey()));
        Map<Integer, List<Integer>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
