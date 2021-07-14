package com.example.sort;

/**
 * 겹치는 시간 병합
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TimeIntervalMerge {

    public static void main(String[] args) {

        TimeIntervalMerge tim = new TimeIntervalMerge();

        int[][] t1 = new int[][] {{1,5},{5,6}};
        int[][] t2 = new int[][] {{1,4},{2,6},{8,10},{15,18}};

        int[][] result = tim.solve(t2);
        for(int[] r : result) {
            System.out.println(r[0] + ","+r[1]);
        }
    }

    public int [][] solve(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if (end >= intervals[i][0]) { // 종료시간과 시작시간이 겹치는 경우
                end = Math.max(end, intervals[i][1]); // 두 시간에서 종료시간이 더 긴 쪽으로 merge
            } else { // 시간이 겹치지 않는 경우
                res.add(new int[]{start, end}); // 지금까지 merge된 시작시간과 종료시간을 한 개 interval로 추가
                start = intervals[i][0]; // 시작 시간 갱신
                end = intervals[i][1]; // 종료 시간 갱신
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}
