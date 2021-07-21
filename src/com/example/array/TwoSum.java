package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 두 개의 합 문제 O(N) 풀이
 *
 * Array + Map
 * - Map의 key에는 타겟값 - 현재 값을 저장
 * - Map의 value에는 현재 인덱스를 저장
 * - Map의 key와 같은 값을 만나게 되면 그 값과 Map에 저장된 인덱스의 값의 합이 타겟이 되는 것.
 */

public class TwoSum {

    public static void main(String[] args) {
        int target = 20;
        int[] t1 = new int[]{1, 6, 11, 14};

        TwoSum ts = new TwoSum();
        int[] result = ts.solve(t1, target);

        for(int r : result) {
            System.out.print(r + " ");
        }
    }

    private int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target-nums[i], i);
            }
        }
        return new int[]{0,0};
    }
}
