package gyeol.week02;

import java.util.ArrayDeque;

public class 괄호회전하기 {
    public int solution(String s) {
        // 올바른 괄호 문자열 카운트
        int answer = 0;
        int len = s.length();

        // 한칸씩 뒤로 미루기
        for (int i = 0; i < len; i++) {
            answer += count(s.substring(i) + s.substring(0, i));
        }
        return answer;
    }

    // 변형된 문자열 삭제한 거 카운트해주는 메서드
    public int count(String newS) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        int len = newS.length();
        for (int i = 0; i < len; i++) {

            // 1-1. 여는 괄호면 무조건 push
            if (newS.charAt(i) == '('
                    || newS.charAt(i) == '['
                    || newS.charAt(i) == '{') {
                deque.addLast(newS.charAt(i));
            } else {
                // 1-2. 닫는 괄호인데 덱이 비었으면 무조건 push
                if (deque.isEmpty()) {
                    deque.addLast(newS.charAt(i));
                }

                // 1-3. 닫는 괄호인데 앞에 짝이 맞는 여는 괄호가 있으면 poll
                char peek = deque.peekLast();
                if ((newS.charAt(i) == ')' && peek == '(') ||
                        (newS.charAt(i) == ']' && peek == '[') ||
                        (newS.charAt(i) == '}' && peek == '{')) {
                    deque.pollLast();

                } else {
                    // 1-4. 닫는 괄호인데 앞에 짝이 맞는 괄호가 아니면 push
                    deque.addLast(newS.charAt(i));
                }
            }
        }

        // 2-1. 덱이 비었으면 1 반환
        if (deque.isEmpty()) {
            return 1;
        }

        // 2-2. 비지않았으면 0반환
        return 0;
    }
}
// O(N^2)
// push: 여는괄호, 앞에 여는괄호가 없는 닫는 괄호, empty
// poll: 앞에 여는괄호가 있는 닫는 괄호
