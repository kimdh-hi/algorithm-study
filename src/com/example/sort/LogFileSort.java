package com.example.sort;

import java.util.Arrays;

public class LogFileSort {

    public static void main(String[] args) {
        String[] t1 = {
                "dig1 8 2 3 1",
                "let1 abc cat",
                "dig1 2 5",
                "let2 good dog book",
                "let3 abc zoo"};

        LogFileSort lfs = new LogFileSort();
    }

    public void solve(String[] logs) {
        Arrays.sort(logs, (a, b)->{
            String[] s1 = a.split(" ", 2);
            String[] s2 = b.split(" ", 2);

            boolean isDigitS1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigitS2 = Character.isDigit(s2[1].charAt(0));

            if (!isDigitS1 && ! isDigitS2) {
                int comp = s1[1].compareTo(s2[1]);
                if (comp == 0)
                    return s1[0].compareTo(s2[0]);
                else
                    return comp;
            } else if (isDigitS1 && isDigitS2) {
                return 0;
            } else if (isDigitS1 && !isDigitS2) {
                return 1;
            } else {
                return -1;
            }
        });
    }
}
