package gyeol.week03;

import java.util.ArrayDeque;

public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 1. cards1,2를 큐에 넣는다.
        ArrayDeque<String> c1 = new ArrayDeque<>();
        ArrayDeque<String> c2 = new ArrayDeque<>();
        for (String c : cards1) {
            c1.addLast(c);
        };
        for (String c : cards2) {
            c2.addLast(c);
        };

        // 2. goal길이만큼 for문을 돌린다.
        int goalLen = goal.length;
        for (int i = 0; i < goalLen; i++) {

            // 3. for문 안에서 1과 2의 peek에 해당하면 poll
            if (goal[i].equals(c1.peekFirst())) {
                c1.pollFirst();
            }
            else if (goal[i].equals(c2.peekFirst())) {
                c2.pollFirst();
            }
            else {

                // 4. 한번이라도 예외가 나온다면 "No"반환
                return "No";
            }
        }

        // 5. 한번의 예외도 발생하지 않고 다 통과한다면 "Yes"반환
        return "Yes";
    }
}
