package com.example.boj;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i=0;i<t;i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), ",");
            int inputCnt = 0;
            Stack<Integer> lStack = new Stack<>();
            Stack<Integer> rStack = new Stack<>();

            while (inputCnt < n) {
                String tmp = st.nextToken();
                if (tmp.equals("[") || tmp.equals("]")) continue;

                lStack.push(Integer.parseInt(tmp));
                ++inputCnt;
            }

            StringBuilder sb = new StringBuilder("[");
            boolean errorFlag = false;
            for (int k=0;k<command.length();k++) {
                if(errorFlag) break;
                char c = command.charAt(k);
                switch (c) {
                    case 'R':
                        if (lStack.empty()) {
                            while (!rStack.empty()) {
                                lStack.push(rStack.pop());
                            }
                        } else if (rStack.empty()) {
                            while (!lStack.isEmpty()) {
                                rStack.push(lStack.pop());
                            }
                        }
                    case 'D':
                        if (rStack.empty() && lStack.empty()) {
                            System.out.println("error");
                            errorFlag = true;
                            break;
                        } else {
                            if (!lStack.isEmpty()) {
                                sb.append(lStack.pop() + ",");
                            } else {
                                sb.append(rStack.pop() + ",");
                            }
                        }
                    default: break;
                }
            }
            if (!errorFlag) {
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}
