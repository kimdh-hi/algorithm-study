package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10250
 * ACM 호텔
 */

public class Q10250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        int h=0,w=0,n=0;
        for (int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine(), " ");

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            // h가 6일때 n이 6의 배수일 때 h층이 나오게 하기 위함
            if (n%h==0) sb.append((h*100)+(n/h)).append("\n");
            else sb.append((n%h)*100 + (n/h)+1).append("\n");
        }
        System.out.print(sb.toString());
    }
}
