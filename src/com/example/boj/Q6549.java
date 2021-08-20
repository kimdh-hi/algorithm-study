package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q6549 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            if (n==0) break;

            int[] hist = new int[n];

            for (int i=0;i<n;i++) {
                hist[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getMaxArea(hist) + "\n");
        }
        System.out.print(sb.toString());
    }
    public static long getMaxArea(int[] hist) {
        Stack<Integer> stack = new Stack<>();
        long max = -1;

        for (int i=0;i<hist.length;i++) {
            while (!stack.isEmpty() && hist[stack.peek()] > hist[i] ) {
                int height = hist[stack.pop()];

                int width = 0;
                if (stack.isEmpty()) width = i; // 이전 막대가 없는 경우 넓이
                else width = i-stack.peek()-1;

                max = Math.max(max, (long)height * width);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int height = hist[stack.pop()];
            int width = stack.isEmpty() ? hist.length : hist.length-stack.peek()-1;
            max = Math.max(max, (long)height*width);
        }
        return max;
    }
}
