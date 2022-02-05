package com.example.programmers;

public class programmers_8 {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30,1,21,17,28};
        programmers_8 a = new programmers_8();
        String[] solution = a.solution(n, arr1, arr2);
        for (String s : solution) {
            System.out.println(s);
        }
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i=0;i<n;i++) {
            String b1 = toBinary(arr1[i], n, new StringBuilder());
            String b2 = toBinary(arr2[i], n, new StringBuilder());
            StringBuilder tmp = new StringBuilder();
            for(int j=0;j<n;j++) {
                if (b1.charAt(j) == '1' || b2.charAt(j) == '1') {
                    tmp.append("#");
                } else {
                    tmp.append(" ");
                }
            }
            answer[i] = tmp.toString();

        }
        return answer;
    }
    public String toBinary(int n, int size, StringBuilder sb) {
        if (n==1) {
            sb.append(String.valueOf(n));
            while (sb.length() < size) {
                sb.append("0");
            }
            return sb.reverse().toString();
        } else {
            sb.append(String.valueOf(n%2));
            n/=2;
            return toBinary(n, size, sb);
        }
    }
}
