package com.example.programmers;


import java.util.HashSet;
import java.util.Set;

public class programmers_24 {

    public static void main(String[] args) {
        programmers_24 a = new programmers_24();
        int result = a.solution("zxzxz");
        System.out.println(result);
    }

    public int solution(String s) {
        int count = 0;
        int strLen = s.length();
        if (strLen == 1) return 1;

        for (int i=1;i<=strLen;i++) {
            Set<String> set = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for (int j=0;j<strLen;j++) {
                if (j + i > strLen) continue;
                String compStr = s.substring(j, j + i);
                if (!set.contains(compStr)) {
                    set.add(compStr);
                    boolean flag = true;
                    for (int k = 0; k < compStr.length(); k++) {
                        char compChar = compStr.charAt(k);
                        if (set2.contains(compChar)) {
                            flag = false;
                            break;
                        }
                        set2.add(compChar);
                    }
                    if (flag) {
                        ++count;
                        System.out.println(compStr);
                    }
                    set2.clear();
                }
            }
            set.clear();
        }

        return count;
    }
}
