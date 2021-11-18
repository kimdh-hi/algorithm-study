package com.example.boj;

import java.util.Scanner;

public class Q9663 {

    public static int n;
    public static int cnt=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int result = 0;

        int[] arr = new int[n];
        for (int i=0; i<n; i++ ){

            // 1행 i열에 퀸을 놓고 시작
            arr[0] = i;
            dfs(arr, 0);
        }
        System.out.println(cnt);
    }

    public static void dfs(int[] arr, int row) {
        if (row == n) {
            cnt++;
            return;
        } else {
            for (int i=0; i<n; i++) {
                arr[row+1] = i;
                if (check(arr, row, i)) {
                    dfs(arr, row+1);
                }
            }
        }
    }

    public static boolean check(int[] arr, int row, int col) {
        // 같은 행
        // 같은 열
        // r까지의 대각선
        for (int i=1; i<row; i++) {
            if (arr[row] == arr[i]) return false;
            if (Math.abs(i - col) == Math.abs(arr[i] - arr[col])) return false;
        }
        return true;
    }
}
