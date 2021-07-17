package com.example.array;

/**
 * 빗물담기
 * {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
 * 0은 빈 부분
 * 1은 담이 쌓아진 부분
 *
 * 자신을 기준으로 왼쪽으로부터 최대 담의 높이를 저장하는 배열 하나
 * 자신을 기준으로 오른쪽으로부터 최대 담의 높이를 저장하는 배열 하나
 *
 * 자신의 담 높이 - Min(해당 인덱스에서 왼쪽의 최대 담 높이, 해당 인덱스에서 오른쪽 최대 담 높이)
 */
public class TrappingRainWater {

    public static void main(String[] args) {

        int[] t1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        TrappingRainWater tr = new TrappingRainWater();
        System.out.println(tr.solve(t1));
    }

    private int solve(int[] arr) {
        int len = arr.length;

        int[] left = new int[len];
        int[] right = new int[len];
        int res = 0;
        left[0] = arr[0];
        int max_height = left[0];
        for (int i=1; i<len; i++) {
            if (arr[i] > max_height) {
                left[i] = arr[i];
                max_height = arr[i];
            } else {
                left[i] =  max_height;
            }
        }

        right[len-1] = arr[len-1];
        max_height = right[len-1];
        for (int i=len-1; i>=0; i--) {
            if (arr[i] > max_height) {
                max_height = arr[i];
                right[i] = arr[i];
            } else {
                right[i] = max_height;
            }
        }

        for (int i=0; i<len; i++) {
            res += Math.min(left[i], right[i]) - arr[i];
        }
        return res;
    }

}
