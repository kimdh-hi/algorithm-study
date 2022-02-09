package com.example.boj;

/**
 * LinkedList 실패
 */

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Q1406 {

    public static void main(String[] args) throws IOException {
        List<Character> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String initialStr = br.readLine();
        int m = Integer.parseInt(br.readLine());

        int cursor = initialStr.length();

        for (int i=0;i<initialStr.length();i++) {
            list.add(initialStr.charAt(i));
        }

        for (int i=0;i<m;i++) {
            String commandLine = br.readLine();
            char command = commandLine.charAt(0);
            switch (command) {
                case 'P':
                    list.add(cursor++, commandLine.charAt(2));
                    break;
                case 'B':
                    if (cursor > 0) list.remove(--cursor);
                    break;
                case 'L':
                    if (cursor > 0) --cursor;
                    break;
                case 'D':
                    if (cursor < list.size()) ++cursor;
                    break;
                default:
                    break;
            }
        }

        for (Character c : list) {
            bw.write(c);
        }

        br.close();
        bw.close();
    }
}
