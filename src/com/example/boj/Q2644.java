package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] adj = new int[n+1][n+1];
        int[] check = new int[n+1];
        Arrays.fill(check, -1);

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = 1;
            adj[y][x] = 1;
        }

        int answer = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        check[a] = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == b) {
                answer = check[curr];
                break;
            }
            for (int i=0;i<adj[curr].length;i++) {
                int tmp = adj[curr][i];
                if (tmp == 1 && check[i] == -1) {
                    queue.offer(i);
                    check[i] = check[curr] + 1;
                }
            }
        }
        System.out.println(answer);
    }
}
