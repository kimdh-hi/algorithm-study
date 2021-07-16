package com.example.array;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams a = new GroupAnagrams();

        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

        a.print(a.solve1(strs));
        a.print(a.solve2(strs));
        a.print(a.solve3(strs));
    }


    private List<List<String>> solve1(String[] arr) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : arr) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String s = String.valueOf(carr);

            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    /**
     * Map.containsKey() -> Map.getOrDefault()
     */
    private List<List<String>> solve2(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : arr) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String key = String.valueOf(carr);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private List<List<String>> solve3(String[] arr) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str: arr) {
            int[] alp = new int[26];
            for (int i=0; i<str.length(); i++) {
                alp[str.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(alp);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private void print(List<List<String>> strs) {
        for (List<String> strs1 : strs) {
            for (String str : strs1) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
