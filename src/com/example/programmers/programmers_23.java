package com.example.programmers;



public class programmers_23 {

    public static void main(String[] args) {
        programmers_23 a = new programmers_23();
        String result = a.solution("aAb");
        System.out.println(result);
    }

    public String solution(String s){
        StringBuilder sb = new StringBuilder();
        String lowerStr = s.toLowerCase();
        long maxCount = Integer.MIN_VALUE;
        long[] alp = new long[26];

        for (int i=0;i<lowerStr.length();i++) {
            System.out.println(lowerStr.charAt(i) - 'a');
            alp[lowerStr.charAt(i)-'a']++;
        }
        for (int i=0;i<alp.length;i++) {
            maxCount = Math.max(maxCount, alp[i]);
        }
        for (int i=0;i<alp.length;i++) {
            if (alp[i] == maxCount) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}
