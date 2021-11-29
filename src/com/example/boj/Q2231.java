package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int res = 0;
        for (int i=1; i<=n; i++) {
            int tmp = i;
            int sum = 0;
            char[] chars = String.valueOf(i).toCharArray();
            for (char c : chars) {
                sum += Integer.parseInt(String.valueOf(c));
            }
            if (tmp+sum == n) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}
