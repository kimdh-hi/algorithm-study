package com.example;

import java.util.*;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String s = "cdcd";
        s = s.replaceAll("[a-z]{2,2}","");
        System.out.println("s = " + s);
    }
}