package com.example.boj;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Point> points = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(points);

        for (int i=0;i<n;i++) {
            bw.write(points.get(i).x + " " + points.get(i).y + "\n");
        }

        bw.close();
        br.close();
    }

    static class Point implements Comparable {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;

            if (this.x != p.x) {
                return Integer.compare(this.x, p.x);
            }
            return Integer.compare(this.y, p.y);
        }


    }
}
