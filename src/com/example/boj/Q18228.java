package com.example.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] ice = new int[n];
        for (int i=0;i<n;i++) {
            String s = st.nextToken();
            ice[i] = Integer.parseInt(s);
        }
        int pidx = 0;
        for (int i=0;i<n;i++) {
            if (ice[i] == -1) pidx = i;
        }
        int lmin = 1000000001;
        for (int i=1;i<pidx;i++) {
            lmin = Math.min(ice[i], lmin);
        }
        int rmin = 1000000001;
        for (int i=pidx+1; i<n;i++) {
            rmin = Math.min(ice[i], rmin);
        }
        System.out.print(ice[0] + rmin < ice[n-1] +lmin ? ice[0]+rmin : ice[n-1]+lmin);
    }
}
