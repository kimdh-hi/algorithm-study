package com.example.boj;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Q1026 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a_arr = new int[n];
        int[] b_arr = new int[n];

        for (int i=0;i<n;i++) {
            a_arr[i] = sc.nextInt();
        }
        for (int i=0;i<n;i++) {
            b_arr[i] = sc.nextInt();
        }
        Arrays.sort(a_arr);
        Arrays.sort(b_arr);

        int result = 0;
        for (int i=0;i<n;i++) {
            result += a_arr[i] * b_arr[n-i-1];
        }
        System.out.println(result);
    }
}
