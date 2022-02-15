package com.example.programmers;

// https://programmers.co.kr/learn/courses/30/lessons/42626
// 더 맵게

import java.util.*;
public class programmers_26 {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소힙

        for (int i=0;i<scoville.length;i++) {
            pq.offer(scoville[i]);
        }

        while(pq.peek() < K) {
            if (pq.size() <= 2) { // 힙의 크기가 2이하인 경우 반복(혼합) 종료
                break;
            }
            int s1 = pq.poll(); // 스코빌지수 최소값
            int s2 = pq.poll(); // 스코빌지수 두번째 최소값
            int newScoville = s1 + (s2 * 2); // 혼합
            pq.offer(newScoville);

            ++answer;
        }

        // 두 개가 남을 때까지 혼합했지만 K를 넘지 못했을 때 마지막 두 개 남은 값을 혼합한다
        if (pq.size() == 2 && pq.peek() < K) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            if (s1 + (s2*2) >= K) answer++; // 혼합 후 K를 넘었다면 ++
            else return -1; // 혼합한 결과 K를 넘지 못한다면 -1
        }

        return answer;
    }
}
