package com.example.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 완전탐색 - 모의고사
 */


public class programmers_1 {
    class Solution {
        public int[] solution(int[] answers) {
            int[] res = {};
            int[] t1 = new int[]{1,2,3,4,5};
            int[] t2 = new int[]{2,1,2,3,2,4,2,5};
            int[] t3 = new int[]{3,3,1,1,2,2,4,4,5,5};
            int t1_len = t1.length;
            int t2_len = t2.length;
            int t3_len = t3.length;
            int[] marr = new int[3];
            for (int i=0;i<answers.length;i++) {
                if (t1[i%t1_len] == answers[i]) marr[0]++;
                if (t2[i%t2_len] == answers[i]) marr[1]++;
                if (t3[i%t3_len] == answers[i]) marr[2]++;
            }
            int max = Math.max(Math.max(marr[0],marr[1]),marr[2]);
            List<Integer> list = new ArrayList<>();
            if(marr[0] == max) list.add(0);
            if(marr[1] == max) list.add(1);
            if(marr[2] == max) list.add(2);

            res = new int[list.size()];
            for (int i=0;i<list.size();i++) {
                res[i] = list.get(i)+1;
            }
            return res;
        }
    }
}
