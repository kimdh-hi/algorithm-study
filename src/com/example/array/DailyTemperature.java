package com.example.array;

import java.util.Collections;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        DailyTemperature dt = new DailyTemperature();
        int[] t1 = new int[]{73,74,75,71,69,72,76,73};
        int[] t2 = new int[]{30,40,50,60};
        int[] result1 = dt.solve1(t2);
        for (int n : result1) {
            System.out.print(n +" ");
        }
        System.out.println();
        int[] result2 = dt.solve2(t2);
        for (int n : result2) {
            System.out.print(n +" ");
        }
    }
    private int[] solve1(int[] temp) {
        int n = temp.length;
        int res[] = new int[n];
        for (int i=0;i<n-1;i++) {
            for (int j=i+1; j<n; j++) {
                if (temp[j] > temp[i]) {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }

    private int[] solve2(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<n;i++) {
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i] ) {
                int idx = stack.pop();
                res[idx] = i-idx;
            }
            stack.push(i);
        }
        return res;
    }
}
