package com.example.boj;

import java.io.*;
import java.util.StringTokenizer;

public class Q6603_2 {
    static int k;
    static int[] nums;
    static boolean[] check;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            nums = new int[k];
            check = new boolean[k];
            int idx = 0;
            while (st.hasMoreTokens()) {
                nums[idx++] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if (depth == 6) {
            for(int i=0;i<k;i++) {
                if (check[i]) {
                    bw.write(nums[i] + " ");
                }
            }
            bw.write("\n");
        }

        for (int i=start; i<k; i++) {
            check[i] = true;
            dfs(depth+1, i+1);
            check[i] = false;
        }
    }
}
