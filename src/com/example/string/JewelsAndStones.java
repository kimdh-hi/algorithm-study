package com.example.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 보석과 돌
 *
 * 고유한 알파벳 대소문지로 이루어진 보석 입력
 * 알파벳 대소문자로 이루어진 돌 입력
 *
 * 돌에 보석이 몇 개 있는가?
 */

public class JewelsAndStones {

    public static void main(String[] args) {

        String jewels1 = "aA";
        String stones1 = "aAAbbbb";

        String jewels2 = "z";
        String stones2 = "ZZ";

        JewelsAndStones jas = new JewelsAndStones();

        System.out.println("Q1 = " + jas.solve(jewels1, stones1));
        System.out.println("Q2 = " + jas.solve(jewels2, stones2));
    }

    public int solve(String jew, String stones) {
        char[] jewArr = jew.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i=0; i<jewArr.length;i++) {
            set.add(jewArr[i]); // 고유한 보석
        }

        char[] stoneArr = stones.toCharArray();
        int count = 0;
        for (int i=0;i<stoneArr.length;i++) {
            if (set.contains(stoneArr[i])) { // 돌이 보석에 포함되는지
                count++;
            }
        }
        return count;
    }
}
