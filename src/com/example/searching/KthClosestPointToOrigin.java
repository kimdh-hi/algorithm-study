package com.example.searching;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 원점에서 가까운 k개 좌표를 출력
 *
 * pq 선언시 삽입시 연산을 정의할 수 있음.
 */
public class KthClosestPointToOrigin {

    public static void main(String[] args) {
        int[][] t1 = new int[][]{{3,3}, {5, -1}, {-2, 4}};
        int k1 = 2;
        int[][] t2 = new int[][]{{1,3},{-2,2}};
        int k2 = 1;


        KthClosestPointToOrigin a = new KthClosestPointToOrigin();
        int[][] result = a.solve(t2, k2);

        for(int i=0;i<result.length;i++) {
            System.out.print("[");
            for(int j=0;j<result[i].length;j++) {
                System.out.print(result[i][j]+",");
            }
            System.out.println("]");
        }
    }

    private int[][] solve(int[][] parr, int k) {
        // pq에 삽입시 수행될 연산 지정
        Queue<int[]> pq = new PriorityQueue<>((p1,p2) ->
            (p1[0] * p1[0] + p1[1] * p1[1])-(p2[0] * p2[0] + p2[1] * p2[1])
        );
        // pq에 삽입 (min-heap) 계산된 원점으로부터 최단거리 기준 min-heap
        for (int[] p : parr) {
            pq.offer(p);
        }

        int[][] res = new int[k][2];

        // k번 째까지 리턴
        for (int i=0;i<k;i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
