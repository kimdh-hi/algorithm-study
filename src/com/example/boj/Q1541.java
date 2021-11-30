package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int res = Integer.MAX_VALUE;

        String[] split = s.split("-");
        for (String s1 : split) {
            String[] split1 = s1.split("\\+");
            int tmp = 0;
            for (String s2 : split1) {
                tmp += Integer.parseInt(s2);
            }
            if (res == Integer.MAX_VALUE) {
                res = tmp;
            }  else {
                res -= tmp;
            }
        }
        System.out.println(res);
    }
}
