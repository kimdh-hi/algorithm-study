package com.example.stack;


import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {

        ValidParentheses a = new ValidParentheses();

        String t1 = "(){}[]";
        String t2 = "(}})[]";
        String t3 = "([)]";
        boolean result = a.solve(t2);

        System.out.println(result);
    }

    private boolean solve(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i=0;i <str.length();i++ ){
            Character c = str.charAt(i);
            if (c == '(' && c == '{' && c == '[') { // 열리는 괄호라면 스택에 삽입
                stack.push(c);
            }
            else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') { // ')'일 때 스택의 최상단이 '('일때만 pop
                stack.pop();
            } else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') { // '}'일 때 스택의 최상단이 '{'일때만 pop
                stack.pop();
            } else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') { // ']'일 때 스택의 최상단이 '['일때만 pop
                stack.pop();
            } else { // 짝을 맞추지 못하는 경우 false
                return false;
            }
        }
        return stack.isEmpty(); // 모두 짝을 맞추어 pop되어 스택이 비었을 때 true 리턴
    }
}
