package com.example.searching;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * K번째 큰 원소
 */
public class KthLargest {

    public static void main(String[] args) {

        KthLargest a = new KthLargest();

        int[] t1 = new int[]{2,3,1,5,6,4};
        int[] t2 = new int[]{3,2,3,1,2,4,5,6};
        int k = 2;
        System.out.println(a.solve1(t1, k));
    }

    /**
     * PriorityQueue (min-Heap)
     */
    private int solve1(int[] arr,int k) {
        Queue<Integer> pq = new PriorityQueue<>(); // default: 오름차순 (min-heap)
        for (int a : arr) {
            pq.offer(a); // 순서대로 큐에 삽입 (heapify)
            if (pq.size() > k) { // k개 만큼의 heap만 유지
                pq.poll();
            }
        }
        return pq.peek(); // min-heap의 루트노드 값이 k번째 큰 값이 됨
    }
}
