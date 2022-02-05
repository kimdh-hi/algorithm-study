package com.example.programmers;

import java.util.ArrayList;
import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 * 2019 KAKAO BLIND RECRUITMENT
 * 오픈채팅방
 */

public class programmers_15 {
    public static void main(String[] args) {
        String[] t1 = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        programmers_15 a = new programmers_15();
        String[] solution = a.solution(t1);
        for (String s : solution) {
            System.out.println(s);
        }
    }
    public String[] solution(String[] record) {

        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (int i=0;i<record.length;i++) {
            String[] tmp = record[i].split(" ");
            if (tmp[0].equals("Enter")) {
                map.put(tmp[1], tmp[2]);
                answer.add(tmp[1]+"님이 들어왔습니다.");
            }
            else if (tmp[0].equals("Leave")) {
                answer.add(tmp[1]+"님이 나갔습니다.");
            }
            else if (tmp[0].equals("Change")) {
                map.put(tmp[1],tmp[2]);
            }
        }
        String[] res = new String[answer.size()];
        for (int i=0;i<answer.size();i++) {
            String uid = answer.get(i).split(" ")[0];
            uid = uid.substring(0, uid.length() - 2);
            String nickname = map.get(uid);
            String newAns = answer.get(i).replaceAll(uid, nickname);
            res[i] = newAns;
        }

        return res;
    }
}
