package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        int a=0,b=1;
        if (n==1) res = 1;
        else {
            for (int i=2;i<=n;i++) {
                res = a+b;
                a = b;
                b = res;
            }
        }
        System.out.println(res);
    }

}
