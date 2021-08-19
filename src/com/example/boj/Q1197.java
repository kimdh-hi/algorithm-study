package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Q1197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // i번째 노드의 부모를 저장
        // 인덱스: 노드
        // 값: 부모
        int[] parent = new int[n+1];
        for (int i=0;i<parent.length;i++) {
            parent[i] = i;
        }
        // 가중치로 정렬을 위해 우선순위 큐 사용 (Comparable-compareTo 구현)
        Queue<Node> pq = new PriorityQueue<>();
        int x=0,y=0,w=0;
        for (int i=0; i<m;i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            pq.offer(new Node(x, y, w));
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            // 노드가 가중치로 정렬되었으므로 가중치가 가장 작은 간선부터 받아옴
            Node node = pq.poll();
            int a = find(parent, node.from);
            int b = find(parent, node.to);
            if (a != b) { // 같은 부모를 가지면 사이클 발생 (최소 비용 신장 트리 조건x)
                union(parent, a, b); // 부모가 다른 경우 두 노드를 합쳐줌
                sum += node.dis;
            }
        }
        System.out.println(sum);
        br.close();
    }
    // 자신의 루트부모노드를 찾는 함수
    public static int find(int[] parent, int x) {
        if (x == parent[x]) return x; // 종료조건 (부모와 같은 경우 부모를 찾은 것)
        return parent[x] = find(parent, parent[x]); // 자신의 부모의 부모를 찾기위해 재귀호출
    }
    // 부모노드를 함치는 함수 (같은 그래프에 속하도록 합치는 함수)
    public static void union(int[] parent, int x, int y) {
        // 합치고자 하는 두 개 노드의 부모를 찾음
        x = find(parent, x);
        y = find(parent, y);
        // 더 작은 노드로 합쳐줌
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
    // 같은 부모를 같는지 (같은 그래프에 속해있는지)
    public static boolean isSameParent(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);
        return x==y;
    }

    static class Node implements Comparable<Node>{
        public int from;
        public int to;
        public int dis;

        public Node(int from, int to, int dis) {
            this.from = from;
            this.to = to;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node node) {
            return dis - node.dis;
        }
    }
}
