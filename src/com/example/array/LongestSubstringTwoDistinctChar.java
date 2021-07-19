package com.example.array;

/**
 * 2개 문자로 이루어진 가장 긴 고유 문자열의 길이
 *
 * map을 이용한 투 포인터 풀이
 */
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoDistinctChar {
    public static void main(String[] args) {
        String t1 = "eceba";   // ==> "ece"
        String t2 = "ccaabbb"; // ==> "aabbb"

        LongestSubstringTwoDistinctChar a = new LongestSubstringTwoDistinctChar();
        System.out.println(a.solve(t1));
        System.out.println(a.solve(t2));
    }

    private int solve(String str) {
        int len = str.length();
        int left=0, right=0;
        int cnt=0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right < len) {
            char c = str.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1); // map에 없다면 1, 있다면 +1
            right++; // 다음 문자로 이동
            if (map.get(c) == 1) cnt++; // map에 최초 추가시 value는 1 따라서 1로 추가될 때 카운팅
            while(cnt>=3) { // map에 3개 값이 담겼을 때
                // 가장 앞 한 종류의 문자를 삭제
                // left가 가리키는 값이 map에 들어있는 만큼 value를 -1
                map.put(str.charAt(left), map.get(str.charAt(left))-1);
                if(map.get(str.charAt(left)) == 0) cnt--; // value가 0이라는 것은 해당 문자가 존재하지 않는 것 (지워진 것)
                left++; // 왼쪽 포인터 이동
            }
            max = Math.max(max, right-left);
        }
        return max;
    }
}
