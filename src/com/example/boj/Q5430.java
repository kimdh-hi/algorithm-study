package com.example.boj;

import java.io.*;
import java.util.*;

public class Q5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String numsInput = br.readLine();
            String[] nums = numsInput.substring(1, numsInput.length() - 1).split(",");

            Deque<String> dq = new ArrayDeque<>();
            for (String num : nums) {
                if (num.length() > 0) dq.offer(num);
            }

            boolean errorFlag = false; // dq가 비어있는 상태에서 'D' 명령어를 수행할 때 발생하는 에러 플래그
            boolean isLeft = true; // 방향을 나타내는 변수 (true=왼쪽=first, false=오른쪽=last)
            for (int j = 0; j < command.length(); j++) {
                if (errorFlag) break;
                int c = command.charAt(j);

                switch (c) {
                    case 'R':
                        isLeft = !isLeft; // 방향 뒤집기
                        break;
                    case 'D':
                        if (dq.isEmpty()) { // dq가 빈 경우 에러 메시지 출력 후 플래그 세팅
                            sb.append("error").append("\n");
                            errorFlag = true;
                            break;
                        }
                        if (isLeft) { // 왼쪽 첫번째 원소를 삭제하는 경우 (시작)
                            dq.pollFirst();
                        } else { // 오른쪽 첫번째 원소를 삭제하는 경우 (끝)
                            dq.pollLast();
                        }
                        break;
                    default:
                        break;
                }
            }
            if (!errorFlag) {
                sb.append("[");
                boolean isFirstNumber = true; // 출력 포멧을 맞추기 위한 플래그 변수
                while (!dq.isEmpty()) {
                    // 마지막 명령어를 수행했을 때의 방향을 기준으로 출력해줘야 한다.
                    if (isLeft) {
                        if (!isFirstNumber) sb.append(",").append(dq.pollFirst());
                        else {
                            sb.append(dq.pollFirst());
                            isFirstNumber = false;
                        }
                    } else {
                        if (!isFirstNumber) sb.append(",").append(dq.pollLast());
                        else {
                            sb.append(dq.pollLast());
                            isFirstNumber = false;
                        }
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
