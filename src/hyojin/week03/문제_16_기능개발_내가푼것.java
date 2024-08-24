package hyojin.week03;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 문제_16_기능개발_내가푼것 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
//        int[] progresses = {93, 55, 30};
        int[] speeds = {1, 30, 5};
//        int[] speeds = {100, 5, 30};

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 작업의 진행 상태와 속도를 큐에 추가
        for (int i = 0; i < progresses.length; i++) {
            queue.addLast(new int[] {progresses[i], speeds[i]});
        }

        ArrayList<Integer> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            int result = 0;

            // 하루의 진행 상황을 업데이트
            for (int i = 0; i < queue.size(); i++) {
                int[] task = queue.pollFirst();
                task[0] += task[1];
                queue.addLast(task);
            }

            // 완료된 작업을 배포
            while (!queue.isEmpty() && queue.peek()[0] >= 100) {
                queue.pollFirst();
                result++;
            }

            if (result > 0) {
                answer.add(result);
            }
        }

        // 결과를 int 배열로 반환
        int[] ints = answer.stream().mapToInt(i -> i).toArray();
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
