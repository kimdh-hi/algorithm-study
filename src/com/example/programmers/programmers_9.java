package com.example.programmers;

/**
 * 2018 KAKAO BLIND RECRUITMEN [1차] 다트 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 */
public class programmers_9 {
    public static void main(String[] args) {

    }
    public int solution(String dartResult) {
        int[] round = new int[3];
        char[] carr = dartResult.toCharArray();
        int idx = -1;
        for (int i=0;i<carr.length;i++) {
            // n번째 라운드에 쏜 점수
            if (carr[i] >= '0' && carr[i] <= '9') {
                idx++;
                round[idx] += Integer.parseInt(String.valueOf(carr[i]));
                if (i+1!=carr.length-1 && carr[i+1] == '0'&& carr[i] == '1') {
                    round[idx] -= Integer.parseInt(String.valueOf(carr[i]));
                    round[idx] = 10;
                    i++;

                }
            } else if (carr[i] == 'D') {
                round[idx] *= round[idx];
            } else if(carr[i] == 'T') {
                round[idx] *= round[idx] * round[idx];
            } else if (carr[i] == '*') {
                if (idx > 0) round[idx-1] *=2;
                round[idx] *= 2;
            } else if (carr[i] == '#') {
                round[idx] *= -1;
            }
        }
        return round[0] + round[1] + round[2];
    }
}
