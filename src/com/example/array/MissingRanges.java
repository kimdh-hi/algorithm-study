package com.example.array;

import java.util.ArrayList;
import java.util.List;


/**
 * 누락된 숫자 범위
 *
 * n~m 까지의 범위가 있을 때 입력받은 숫자를 제외한 누락된 숫자를 구하시오
 * 누락된 숫자가 연속되는 경우 x->y의 형태로 표현
 * 누락된 숫자가 하나인 경우 하나만 출력
 */
public class MissingRanges {

    public static void main(String[] args) {

        Integer[] t1 = new Integer[]{2,3,5,50,75};

        MissingRanges mr = new MissingRanges();
        List<String> solve = mr.solve(t1, 0, 99);

        for (String s : solve) {
            System.out.println(s);
        }
    }

    private List<String> solve(Integer[] arr, int lower, int upper) {

        List<String> res = new ArrayList<>();
        int len = arr.length;
        if (arr[0]  > lower) {
            res.add(makeForm(lower, arr[0]-1));
        }

        for (int i=0; i<len-1; i++) {
            if (arr[i]+1 < arr[i+1]) {
                res.add(makeForm(arr[i]+1, arr[i+1]-1));
            }
        }

        if (arr[len-1] < upper) {
            res.add(makeForm(arr[len-1]+1, upper));
        }

        return res;
    }

    static String makeForm(int a, int b) {
        return a == b ? String.valueOf(a) : a+"->"+b;
    }
}
