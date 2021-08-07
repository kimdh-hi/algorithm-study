package com.example.programmers;

/**
 * 문자열 속 문자형태 숫자를 숫자로 변환하여 숫자로 반한
 */

public class programmer_4_1 {

    public static void main(String[] args) {
        String t1 = "one4seveneight";
        String t2 = "23four5six7";

        programmer_4_1 t = new programmer_4_1();
        System.out.println(t.solution(t2));
    }

    public int solution(String str) {
        String[] alp = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        String[] digit = {"0","1","2","3","4","5","6","7","8","9"};
        for (int i=0;i<10;i++) {
            str = str.replaceAll(alp[i],digit[i]);
        }
        return Integer.parseInt(str);
    }
}
