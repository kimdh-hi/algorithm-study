package com.example.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 주어진 이차원 배열은 회의의 시작시간, 종료시간으로 되어있음
 * 모든 회의가 시간이 겹치치 않고 이루어질 수 있는지 true / false
 */

public class MeetingRoom {

    public static void main(String[] args) {

        MeetingRoom mr = new MeetingRoom();

        int[][] t1 = new int[][] {{5,10}, {16,20}, {0,30}};
        int[][] t2 = new int[][] {{6,10}, {1,3}};
        System.out.println(mr.solve(t1));
    }

    private boolean solve(int[][] t) {
        Arrays.sort(t, new Comparator<int[]>() { // 첫번째 원소를 기준으로 정렬 (시작시간을 기준으로 정렬)
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[0];
                else return o1[0] - o2[0];
            }
        });

        int end = t[0][1];
        for(int i=1;i <t.length; i++) {
            if (t[i][0] < end) {
                return false;
            }
            end = t[i][1];
        }
        return true;
    }

    private void print(int[][] t) {
        for(int i=0; i<t.length; i++) {
            for(int j=0; j<t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
    }
}
