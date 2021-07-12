package com.example.string;

/**
 * 비어있지 않은 10진수가 배열로 입력
 * 입력받은 배열의 마지막 원소에 + 1
 * 각 자리에서 carry 반영
 */
public class PlusOne {

    public static void main(String[] args) {

        PlusOne plusOne = new PlusOne();
        int[] t1 = new int[]{1,2,3};
        int[] t2 = new int[]{9,9,9};
        int[] t3 = new int[]{0,0,0};
        int[] t4 = new int[]{0,0,1};
        System.out.println(plusOne.solve(t1));
        System.out.println(plusOne.solve(t2));
        System.out.println(plusOne.solve(t3));
        System.out.println(plusOne.solve(t4));
    }

    private int solve(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a);
        }
        return Integer.parseInt(sb.toString()) + 1;
    }
}

