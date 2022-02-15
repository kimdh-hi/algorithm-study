package com.example.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class programmers_27 {

    public static void main(String[] args) {
        programmers_27 a = new programmers_27();

        int N = 5;
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};

        a.solution(N, stages);
    }

    public int[] solution(int N, int[] stages) {

        List<StageInfo> list = new ArrayList<>();
        for (int i=1;i<=N;i++) {
            list.add(new StageInfo(i));
        }

        for (int i=0;i<stages.length;i++) {
            int stage = stages[i];
            if (stage <= N) {
                list.get(stage-1).ingCount++; // 현재 라운드를 진행 중인 플레이어
                for(int j=1;j<=stage;j++) {
                    list.get(j-1).playerCount++; // 현재 라운드를 진행하는 사람은 이전 라운드에 도달한 것
                }
            } else if (stage == N+1) { // 모든 스테이지를 완료한 플레이어
                for(int j=1;j<=N;j++) {
                    list.get(j-1).playerCount++;
                }
            }
        }
        for(StageInfo s : list) {
            s.calculateFailure();
        }
        Collections.sort(list, Collections.reverseOrder());

        int[] answer = new int[list.size()];

        for (int i=0;i<answer.length;i++) {
            answer[i] = list.get(i).stage;
        }
        return answer;
    }

    class StageInfo implements Comparable<StageInfo> {
        public int stage;
        public int playerCount;
        public int ingCount;
        public double failRate;

        public StageInfo(int stage) {
            this.stage = stage;
            this.playerCount = 0;
            this.ingCount = 0;
        }

        public void calculateFailure() {
            if (ingCount == 0) this.failRate = 0;
            else if (ingCount == playerCount) this.failRate = 1;
            else if (playerCount > 0) {
                this.failRate = Double.valueOf(ingCount) / Double.valueOf(playerCount);
            }
        }

        @Override
        public int compareTo(StageInfo s) {
            return Double.compare(this.failRate, s.failRate);
        }
    }
}
