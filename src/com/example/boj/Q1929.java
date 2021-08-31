package com.example.boj;

import java.util.*;
import java.io.*;

/**
 *
 */

public class Q1929 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[e+1];

        for (int i=2;i<=e;i++) {
            if (!check[i]) {
                if (i>=s && i<=e) sb.append(i).append("\n");
                for (int j = i*2; j <= e; j += i) {
                    check[j] = true;
                }
            }
        }
        System.out.print(sb.toString());
    }
}



