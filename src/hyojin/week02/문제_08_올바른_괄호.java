package hyojin.week02;

import java.util.ArrayDeque;

public class 문제_08_올바른_괄호 {
    public static void main(String[] args) {
        String s = "(())((";
        boolean answer = true;
        char[] chars = s.toCharArray();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char aChar = chars[i];
            if (aChar == ')') {
                if (stack.isEmpty()) {
                    answer = false;
                    break;  // 더 이상 검사할 필요가 없음
                } else {
                    stack.pop();
                }
            } else {
                stack.push(aChar);
            }
        }

        // 스택이 비어있지 않으면 괄호가 올바르지 않음
        if (!stack.isEmpty()) {
            answer = false;
        }

        System.out.println("answer = " + answer);
    }
}
