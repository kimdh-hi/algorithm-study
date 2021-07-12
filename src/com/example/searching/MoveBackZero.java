package com.example.searching;

/**
 * 입력된 정수배열에서 0을 제외하고 순서를 유지한채 0만 뒤 쪽으로 이동
 */
public class MoveBackZero {

    public static void main(String[] args) {

        MoveBackZero mz = new MoveBackZero();

        int[] t1 = new int[]{0,5,6,1,0,0,2};

        int[] result = mz.solve(t1);
        for (int i : result) {
            System.out.print(i);
        }
    }

    private int[] solve(int[] arr) {

        int len = arr.length;
        int idx = 0;
        for (int i=0;i<len;i++) {
            if (arr[i] != 0) {
                arr[idx++] = arr[i];
            }
        }

        for (int i=idx; i<len; i++) {
            arr[i] = 0;
        }

        return arr;
    }
}
