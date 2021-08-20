package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18228
 * 펭귄추락대책위원회
 */

public class Q18228_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int res = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<n;i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur == -1) {
                res += pq.poll();
                pq.clear();
                continue;
            }
            pq.offer(cur);
        }
        System.out.println(res+pq.poll());
    }
}
