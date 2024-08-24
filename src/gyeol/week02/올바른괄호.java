package gyeol.week02;

import java.util.ArrayDeque;

public class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> arr = new ArrayDeque<>();
        int len = s.length();

        // 카운트
        int count = 0;

        // 1. 덱에 집어넣는다.
        // O(N)
        for (int i = 0; i < len; i++) {
            arr.offer(s.charAt(i));
        }

        // 2. 꺼내면서 count를 센다
        // O(N)
        while (!arr.isEmpty()) {
            // 2-1. count이 0이 넘어가면 false
            if(count < 0){
                return false;
            }
            // 2-2. 꺼낼 다음 괄호가 (라면 count+1
            if (arr.peekFirst() == '('){
                count ++;
            } else {
                // 2-3. 꺼낼 다음 괄호가 )라면 count-1
                count --;
            }
            arr.pollFirst();
        }

        // 3 짝이 맞지 않으면 false
        if (count != 0){
            return false;
        }

        return answer;
    }
}
