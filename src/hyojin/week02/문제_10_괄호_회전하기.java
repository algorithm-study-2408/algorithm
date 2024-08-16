package hyojin.week02;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class 문제_10_괄호_회전하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        s += s; // "[](){}" -> "[](){}[](){}"

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // len만큼 이동하여 x의 개수를 찾는다.
        int answer = 0;
        A:for (int i = 0; i < len; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int j = 0; j < i + len; j++) {
                char c = s.charAt(j);   // charAt 메소드 생소함..
                if (!map.containsKey(c)) {
                    // 열린 괄호
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c)))
                        continue A;
                }
            }
            if (stack.isEmpty()) answer++;
        }

        System.out.println("answer = " + answer);

    }
}
