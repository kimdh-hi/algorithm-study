package com.example.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 주어진 회의를 모두 진행 가능한 최소 회의실 개수
 * 회의는 동일한 회의실에서 종료와 동시에 시작될 수 있음
 *
 * priority queue를 이용한 mean-heap 풀이
 * 1. 회의 시작시간을 기준으로 오름차순 정렬
 * 2. pq에 삽입시 종료시간을 기준으로 heapify
 * 3. pq에 삽입시 root노드의 종료시간과 삽입되는 회의의 시작시간을 비교
 *    root노드의 종료시간이 다음 시작시간보다 작다면 pq에서 poll 후 삽입(동일한 회의실에서 진행할 수 있음으로)
 *                                   크다면 pq에 그대로 삽입
 * 4. pq의 크기가 필요한 회의실의 개수
 */

public class MeetingRoom2 {

    public static void main(String[] args) {

        MeetingRoom2 mr2 = new MeetingRoom2();

        int[][] t1 = new int[][] {{5,10}, {16,20}, {0,30}};
        int[][] t2 = new int[][] {{6,10}, {1,3}};
        int[][] t3 = new int[][] {{0,2}, {2,4}, {2,6}};
        int[][] t4 = new int[][] {{1,4},{4,5},{4,6}};

        System.out.println(mr2.solve(t4));
    }

    private int solve(int[][] tarr) {

        Arrays.sort(tarr, (a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        for (int[] t : tarr) {
            if (pq.isEmpty()) {
                pq.offer(t);
            } else {
                if (pq.peek()[1] <= t[0]) {
                    pq.poll();
                }
                pq.offer(t);
            }
        }
        return pq.size();
    }
}
