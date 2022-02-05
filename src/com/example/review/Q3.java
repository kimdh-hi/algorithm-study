package com.example.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q3 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edge = new int[m][3];
        parents = new int[n+1];

        for (int i=1;i<=n;i++) {
            parents[i] = i;
        }

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
            edge[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edge, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for (int i=0;i<edge.length;i++) {
            if(union(edge[i][0], edge[i][1])) {
                answer += edge[i][2];
            }
        }
        System.out.println(answer);
    }

    public static int getParent(int v) {
        if (v == parents[v]) return v;
        return parents[v] = getParent(parents[v]);
    }

    public static boolean union(int x, int y) {
        int xParent = getParent(x);
        int yParent = getParent(y);

        if (xParent != yParent) {
            if (xParent < yParent) parents[yParent] = xParent;
            else parents[xParent] = yParent;
            return true;
        }
        return false;
    }
}
