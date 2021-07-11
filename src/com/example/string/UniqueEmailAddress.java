package com.example.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 문제
 * 입력받은 이메일들로 메일 전송시 몇 개 메일이 보내지는가?
 *
 * 1. 특수문자는 . + @ 사용 가능 (소문자 알파벳만 사용 가능)
 * 2. @ 앞 쪽에서 .이 나오면 무시 (test.kim == testkim)
 * 3. @ 앞 쪽에서 +가 나오면 @ 전까지 문자를 무시 (test+kim@naver.com == test@naver.com)
 * 4. 위 규칙은 @ 뒤 쪽에서는 적용 ❌
 */
public class UniqueEmailAddress {


    public static void main(String[] args) {

        UniqueEmailAddress uea = new UniqueEmailAddress();

        String[] emails = {
                "test.email+kim@naver.com", // => testemail@naver.com
                "test.e.mail+lee@nav.er.com", // => testemail@nav.er.com
                "testemail+park@nav.er.com",   // => testemail@nav.er.com
        };

        System.out.println("========= solve 1 : " + uea.solve1(emails) + " =========");
        System.out.println("========= solve 2 : " + uea.solve2(emails) + " =========");

    }
    public int solve1(String[] emails) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            for (int i=0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c == '.') continue;
                if (c == '+' || c == '@') break;
                sb.append(c);
            }

            set.add(sb.toString() +email.substring(email.indexOf('@')));
            sb = new StringBuilder();
        }
        return set.size();
    }

    /**
     * split
     */
    public int solve2(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] strarr = email.split("@"); // @를 기준으로 split
            String[] localName = strarr[0].split("\\+"); // +를 기준으로 split
            set.add(localName[0].replace(".", "") + "@" + strarr[1]);
        }
        return set.size();
    }
}



