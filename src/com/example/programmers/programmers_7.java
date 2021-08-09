package com.example.programmers;

public class programmers_7 {

    public static void main(String[] args) {
        int t1 = 45;
        programmers_7 a = new programmers_7();
        System.out.println(a.to3(45, ""));
    }

    public String to3(int n, String res) {
        if (n<=2) {
            if (n == 1)
                return res+"1";
            else if (n == 2)
                return res+"2";
            else {
                return res;
            }
        }
        res+=String.valueOf(n%3);
        return to3(n/3, res);
    }
}
