package com.example.programmers;

import com.example.Test;
/**
 * 크레인 인형뽑기
 *
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class programmers_3 {

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};
        programmers_3 a = new programmers_3();
//        System.out.println(a.solution(board, moves));
    }
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> lists = new ArrayList<>();


        for(int i=0;i<board.length;i++) {
            Stack<Integer> tmp_stack = new Stack<>();
            for (int j=board[i].length-1;j>=0;j--) {
                if (board[j][i] != 0) {
                    tmp_stack.push(board[j][i]);
                }
            }
            lists.add(tmp_stack);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<moves.length;i++) {
            Integer tmp;
            if (!lists.get(moves[i]-1).isEmpty() && lists.get(moves[i]-1).peek() != 0) {
                tmp = lists.get(moves[i] - 1).pop();
            }
            else {
                continue;
            }
            System.out.println("tmp = " + tmp);
            if (!stack.isEmpty() && stack.peek() == tmp) {
                stack.pop();
                answer+=2;
            } else {
                stack.push(tmp);
            }
        }
        return answer;
    }
}
