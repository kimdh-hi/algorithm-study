package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;

public class Q11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i=1;i<=n;i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        while (queue.size() > 1) {
            for(int i=0;i<k-1;i++) {
                int tmp = queue.poll();
                queue.offer(tmp);
            }
            sb.append(queue.poll() + ", ");
        }

        sb.append(queue.poll());
        sb.append(">");

        System.out.println(sb.toString());
    }
}
