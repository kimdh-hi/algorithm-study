package com.example.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagram {

    public static void main(String[] args) {

        String t1 = "bacdgabcda";
        String t1_target = "abcd";

        FindAllAnagram a = new FindAllAnagram();
        List<Integer> solve = a.solve(t1, t1_target);
        System.out.println("solve = " + solve);
    }

    private List<Integer> solve(String str, String target) {
        int[] alp = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<str.length();i++) {
            alp[str.charAt(i) - 'a']++;
        }

        for (int i=0;i<str.length()-target.length()+1; i++) {
            int[] alptmp = new int[26];
            for (int j=0;j<str.length();j++) {
                alptmp[str.charAt(i+j) - 'a']++;
            }
            boolean flag = checkAlp(alp, alptmp);
            if (flag) res.add(i);
        }
        return res;
    }
    private boolean checkAlp(int[] a, int[] b) {
        for (int i=0; i<a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
