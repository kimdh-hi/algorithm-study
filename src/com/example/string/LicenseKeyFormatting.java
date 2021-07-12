package com.example.string;

public class LicenseKeyFormatting {

    public static void main(String[] args) {

        String str1 = "8F3Z-2e-9-w";
        String str2 = "8-5g-3-J";
        String str3 = "8F3Z-2e-9-wabcdef";

        LicenseKeyFormatting lkf = new LicenseKeyFormatting();
        System.out.println(lkf.solve(str1, 4));
        System.out.println(lkf.solve(str2, 2));
        System.out.println(lkf.solve(str3, 4));
    }

    public String solve(String key, int k) {
        key = key.replace("-", "");
        key = key.toUpperCase();

        int len = key.length();
        StringBuilder sb = new StringBuilder(key);
        for (int i=len-k; i>0; i-=k) {
            sb.insert(i, "-");
        }
        return sb.toString();
    }
}
