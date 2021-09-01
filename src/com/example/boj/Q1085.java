package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1085
 * 직사각형에서 탈출
 */

public class Q1085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        int minx = Math.min(Math.abs(x-0), Math.abs(x-w));
        int miny = Math.min(Math.abs(y-0), Math.abs(y-z));

        System.out.println(Math.min(minx, miny));
    }
}
