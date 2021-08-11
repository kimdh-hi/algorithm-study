package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String str = "1";
        int n = 0;
        char[] chars = str.toCharArray();
        n += Integer.valueOf(String.valueOf(chars[0]));
        System.out.println("n = " + n);

    }
}
