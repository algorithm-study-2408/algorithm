package gyeol.week03;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int count1 = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        // 1. progress에 speed를 더해서 100이상이 되는 순간을 count1
        for (int i = 0; i < len; i++) {
            count1 = 0;
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                count1++;
            }
            // 2. count한 것을 q에 넣는다.
            q.addLast(count1);
        }
        // 3. first와 peek을 비교해서 first가 더 크거나 같으면 poll 더 작으면 멈추기 <- 더 크거나 같은 순간 count2
        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int count2 = 1;
            int first = q.pollFirst();
            while (!q.isEmpty() && (first >= q.peekFirst())) {
                q.pollFirst();
                count2++;
            }
            // 4. count2를 ArrayList에 담아서 int형 배열로 변환하여 반환
            list.add(count2);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
