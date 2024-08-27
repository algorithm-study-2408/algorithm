package jaehoon.week03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv02_기능개발 {

  // 첫 풀이 - 시간복잡도 : O(N * D)
  public int[] solution1(int[] progresses, int[] speeds) {
    List<Integer> list = new ArrayList<>();

    // 1. progress 요소의 인덱스를 큐에 넣는다.
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < progresses.length; i++) {
      queue.addLast(i);
    }

    // 2. 큐가 빌때까지 작업의 진도율을 올려준다.
    while (!queue.isEmpty()) {
      // 2-1. 1일치 진도율 증가
      for (int i = 0; i < progresses.length; i++) {
        // 진도율이 100보다 작으면 진도율 증가
        if (progresses[i] < 100) {
          progresses[i] += speeds[i];
        }
      }

      // 3. 배포가 가능한지 확인
      // 3-1. 배포가 가능한 기능의 개수 증가 & 큐에서 제거
      // 3-2. 배포가 불가능한 기능을 발견하면, 다시 2번으로 이동
      int count = 0;
      while (!queue.isEmpty() && progresses[queue.peek()] >= 100) {

        // 3-1. 배포가 가능한 기능의 개수 증가 & 큐에서 제거
        queue.pollFirst();
        count++;
      }
      if (count != 0) {
        list.add(count);
      }
    }

    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    return answer;
  }

  // 최적화한 풀이 - 시간복잡도 : O(N)
  public int[] solution2(int[] progresses, int[] speeds) {
    List<Integer> list = new ArrayList<>();

    // 1. progress 요소들의 배포 가능일을 계산해서 큐에 넣음
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < progresses.length; i++) {
      int day = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
      queue.addLast(day);
    }

    // 2. 첫번째 작업의 배포가능일 시점에 뒷 기능개발이 몇개되는지 확인
    while (!queue.isEmpty()) {
      int count = 1;
      int first = queue.pollFirst();

      // 2-1. 첫번째 작업의 다음 요소의 배포 가능일이 더 작은 경우, 같은 날 배포 가능 (큐에서 제거 & 기능 갯수 증가)
      while (!queue.isEmpty() && queue.peek() <= first) {
        queue.pollFirst();
        count++;
      }
      // 2-2. 배포 시점에 완료된 기능 갯수 추가
      list.add(count);
    }

    // 3. 기능 갯수 리스트를 배열로 변환해서 반환
    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    return answer;
  }

  public static void main(String[] args) {
    Lv02_기능개발 main = new Lv02_기능개발();

    // 입력값 예시
    int[] progresses = {95, 90, 99, 99, 80, 99};
    int[] speeds = {1, 1, 1, 1, 1, 1};

    // 출력값 예시
    // 1, 3, 2
    System.out.println("result = " + Arrays.toString(main.solution1(progresses, speeds)));

    // solution1에서 progresses 값이 변경되어 재정의
    progresses = new int[]{95, 90, 99, 99, 80, 99};
    System.out.println("result = " + Arrays.toString(main.solution2(progresses, speeds)));
  }
}