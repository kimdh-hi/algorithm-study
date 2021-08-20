package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1655
 * 가운데를 말해요
 */

public class Q1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Queue<Integer> minH = new PriorityQueue<>((a, b) -> a-b); // min-heap
        Queue<Integer> maxH = new PriorityQueue<>((a, b) -> b-a); // max-heap

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            // 힙의 크기가 서로 같은 경우 max-heap에 우선적으로 삽입
            if (minH.size() == maxH.size()) maxH.add(num);
            else minH.add(num);
            // 최대힙의 루트노드 > 최소힙의 루트노드
            if (maxH.size() > 0 && minH.size() > 0 && maxH.peek() > minH.peek()) {
                Integer tmp = maxH.poll();
                maxH.add(minH.poll());
                minH.add(tmp);
            }

            sb.append(maxH.peek() + "\n");
        }
        System.out.print(sb.toString());
    }
}
