package com.example.boj;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Q10867 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> ts = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0;i<n;i++) {
            ts.add(Integer.parseInt(st.nextToken()));
        }

        for (Integer item : ts) {
            bw.write(item + " ");
        }
        bw.close();
        br.close();
    }
}
