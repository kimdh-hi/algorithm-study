package com.example.boj;

import java.io.*;
import java.util.StringTokenizer;

public class Q6603 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n = 0;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] nums = new int[n];
            int idx = 0;
            while (st.hasMoreTokens()) {
                nums[idx++] = Integer.parseInt(st.nextToken());
            }

        }

    }
}
