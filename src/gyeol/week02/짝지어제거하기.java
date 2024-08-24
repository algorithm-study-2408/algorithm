package gyeol.week02;

import java.util.ArrayDeque;

public class 짝지어제거하기 {
    public int solution(String s) {
        int len = s.length();
        ArrayDeque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            // 1. 덱이 비지 않았을 때, 같으면 안에꺼 꺼내고
            if (!deque.isEmpty()){
                if (deque.peekLast() == s.charAt(i)) {
                    deque.pollLast();
                } else {
                    // 2. 다르면 집어넣고
                    deque.addLast(s.charAt(i));
                }
            } else {
                // 3. 덱이 비었을 때는 꺼낼 수가 없으니 무조건 집어넣기
                deque.addLast(s.charAt(i));
            }
        }


        // 4. 덱이 비었다면 1 아니면 0
        int answer = 0;
        if (deque.isEmpty()){
            answer = 1;
        }

        return answer;
    }
}
