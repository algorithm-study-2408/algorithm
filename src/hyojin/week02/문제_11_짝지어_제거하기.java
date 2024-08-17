package hyojin.week02;

import java.util.ArrayDeque;
import java.util.Scanner;

public class 문제_11_짝지어_제거하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        int answer = 0;

        // stack에 문자열을 추가함과 동시에 이전 글자와 비교하여 같은 글자이면 pop을 진행
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if (peek == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        System.out.println("answer = " + answer);
    }
}
