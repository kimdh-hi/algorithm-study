package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n+1];
        for (int i=0;i<n+1;i++) {
            parent[i] = i;
        }

        Queue<Node> pq = new PriorityQueue<>();
        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            Node node = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pq.offer(node);
        }

        int minSum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int fromParent = find(parent, node.from);
            int toParent = find(parent, node.to);
            if (fromParent != toParent) {
                union(parent, fromParent, toParent);
                minSum += node.weight;
            }
        }
        System.out.println(minSum);
    }

    public static int find(int[] parent, int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent, parent[a]);
    }
    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a != b) {
            if (a < b) parent[b] = a;
            else parent[a] = b;
        }
    }

    public static class Node implements Comparable<Node>{
        private int from;
        private int to;
        private int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }
}