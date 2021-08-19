package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/15591
 * MooTube (Silver)
 */

public class Q15591 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 인접행렬
        List<Node>[] list = new ArrayList[N+1];
        for (int i=0;i<N+1;i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list[p].add(new Node(q, r));
            list[q].add(new Node(p,r));
        }
        for (int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            System.out.println(bfs(list, k, v, N));
        }
    }
    public static int bfs(List<Node>[] list, int k, int v, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n+1];
        q.offer(v); // v번째 영상부터 시작
        visited[v] = 1;
        int cnt = 0;
       while(!q.isEmpty()) {
           int now = q.poll();
           for (Node node : list[now]) { // 연결된 영상을 탐색 (그래프탐색)
               // 다음 정점이 방문되었는지, 다음 정점의 가중치(USADO)가 조건 이상인지
               if (visited[node.to] != 1 && node.weight >= k) {
                   q.offer(node.to);
                   visited[node.to] = 1;
                   cnt++;
               }
           }
       }
       return cnt;
    }

    static class Node{
        public int to;
        public int weight;

        public Node(int to, int u) {
            this.to = to;
            this.weight = u;
        }
    }
}
