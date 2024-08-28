package jaehoon.week03;

import java.util.ArrayDeque;

public class Lv02_프로세스 {

  public int solution(int[] priorities, int location) {
    // 1. 큐에 프로세스 인덱스와 우선순위를 저장 (location이 인덱스를 나타내니깐)
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < priorities.length; i++) {
      queue.add(new int[]{i, priorities[i]});
    }

    // 몇 번째로 실행되는지 셀 변수
    int count = 0;

    // 2. 프로세스가 모두 실행될 때까지 큐에서 POP하면서 확인
    while (!queue.isEmpty()) {
      int[] current = queue.pollFirst();

      // 2-1. 현재 프로세스보다 높은 우선순위가 있는지 확인
      if (isHigherPriorityInQueue(current, queue)) {
        // 높은 우선순위가 있으면 다시 큐에 넣음
        queue.add(current);
      } else {
        // 우선순위가 제일 높아서 실행된
        count++;
        // 실행된 프로세스가 찾는 프로세스(location)라면 그 순서를 반환
        if (current[0] == location) {
          return count;
        }
      }
    }
    return count;
  }

  // 큐를 순회하면서 우선순위 높은게 있으면 true를 리턴
  private boolean isHigherPriorityInQueue(int[] current, ArrayDeque<int[]> queue) {
    boolean hasHigherPriority = false;
    for (int[] process : queue) {
      if (process[1] > current[1]) {  // 우선순위 비교
        return true;
      }
    }
    return hasHigherPriority;
  }

  public static void main(String[] args) {
    Lv02_프로세스 main = new Lv02_프로세스();
    // 입력값 예시
    // 1, 1, 9, 1, 1, 1
    // 0
    int[] priorities = {1, 1, 9, 1, 1, 1};
    int location = 0;

    // 출력값 예시
    // 5
    System.out.println("result= " + main.solution(priorities, location));
  }

}
