package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10757
 * 큰 수 A+B
 */

public class Q10757 {
    static String s1;
    static String s2;
    static int s1_len;
    static int s2_len;
    static int carry;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        s1 = st.nextToken();
        s2 = st.nextToken();
        s1_len = s1.length()-1;
        s2_len = s2.length()-1;
        carry = 0;

        while (s1_len >= 0 || s2_len >= 0) {
            int a = s1_len >= 0 ? s1.charAt(s1_len) - '0' : 0;
            int b = s2_len >= 0 ? s2.charAt(s2_len) - '0' : 0;

            int tmp = a + b + carry;
            carry = tmp/10;
            sb.append(tmp%10);

            s1_len--;
            s2_len--;
        }

        if (carry > 0) sb.append(carry);

        System.out.println(sb.reverse().toString());
    }
}
