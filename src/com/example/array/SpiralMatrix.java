package com.example.array;

/**
 * 2차원 배열을 나선형으로 출력하기
 */

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] t = new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        SpiralMatrix a = new SpiralMatrix();
        a.solve(t);
    }

    private void solve(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        int rowStart = 0;
        int rowEnd = n-1;
        int colStart = 0;
        int colEnd = m-1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 오른쪽으로 출력 (row고정, col증가)
            for (int i=colStart; i<=colEnd; i++) {
                System.out.print(arr[rowStart][i] + " ");
            }
            rowStart++; // col 모두 출력 후 다음 row부터 시작

            // 아래쪽으로 출력 (col고정, row 증가)
            for (int i=rowStart; i<=rowEnd; i++) {
                System.out.print(arr[i][colEnd] + " ");
            }
            colEnd--; // row 모두 출력 후 다시 왼쪽으로 이동하기 위해 col 감소

            // 나선형의 마지막을 체크하기 위한 if (더 출력해야 할 row가 있는 경우에만 왼쪽으로 진행)
            if (rowStart<=rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    System.out.print(arr[rowEnd][i] + " ");
                }
                rowEnd--;
            }

            // 나선형의 마지막을 체크하기 위헌 if (더 출력해야 할 col이 있는 경우에만 위로 진행)
            if (colStart<=colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    System.out.print(arr[i][colStart] + " ");
                }
                colStart++;
            }
        }

    }
}
