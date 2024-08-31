package hyojin.week03;

import java.util.ArrayDeque;

public class 프로세스 {
    public static void main(String[] args) {

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int answer = 0;

        // 1. 큐에 프로세스 인덱스와 우선순위를 저장
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.addLast(new int[] {priorities[i], i});
        }

        // 몇 번째로 실행되는지 셀 변수
        int rank = 0;

        // 2. 프로세스가 모두 실행될 때까지 큐에서 POP하면서 확인
        while (!queue.isEmpty()) {
            int[] currentArray = queue.pollFirst();
            boolean hasHigherPriority = false;

            // 큐를 순회하면서 우선순위 높은 프로세스가 있는지 확인
            for (int[] process : queue) {
                if (process[0] > currentArray[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }

            // 3. 우선순위 높은 프로세스가 있으면 큐의 끝에 다시 삽입
            if (hasHigherPriority) {
                queue.addLast(currentArray);
            } else {
                rank++; // 실제로 실행되는 프로세스이므로 순서 증가
                if (currentArray[1] == location) {
                    answer = rank;
                    break;
                }
            }
        }

        System.out.println("rank = " + answer);
    }
}
