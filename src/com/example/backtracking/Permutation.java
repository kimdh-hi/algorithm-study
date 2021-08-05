package com.example.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * 백트래킹 순열
 *
 * 일단 끝까지 파고들고 가장 끝 요소를 삭제해가며 순회
 */

public class Permutation {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};

        Permutation a = new Permutation();
        List<List<Integer>> result = a.solve(nums);
    }

    public List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        return dfs(nums, list, lists);
    }

    private List<List<Integer>> dfs(int[] nums, List<Integer> list, List<List<Integer>> lists) {

        if (list.size() == nums.length) {
            List<Integer> tmpList = new ArrayList<>(list);
            lists.add(tmpList);
            System.out.println(tmpList);
        }

        for (int i=0;i<nums.length;i++) {
            if (list.contains(nums[i])) continue; // 중복을 허용하지 않는 순열 조건
            list.add(nums[i]);
            dfs(nums, list, lists);
            list.remove(list.size()-1);
        }
        return lists;
    }
}
