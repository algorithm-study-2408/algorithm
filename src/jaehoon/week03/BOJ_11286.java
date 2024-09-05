package jaehoon.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 절댓값 힙
 * https://www.acmicpc.net/problem/11286
 */

/**
 * 우선순위 큐 생성할때
 * Comparator를 PriorityQueue에 인자로 넣을수 있음
 * Comparator<Integer> comparator = new Comparator<>() {
 *
 * @Override public int compare(Integer o1, Integer o2) {
 * if (Math.abs(o1) == Math.abs(o2))
 * return o1 - o2;
 * return Math.abs(o1) - Math.abs(o2);
 * }
 * };
 * <p>
 * PriorityQueue<Integer> pQ = new PriorityQueue<>(comparator);
 */
public class BOJ_11286 {

  public int[] solution(int[] arr) {
    // 1. 우선순위 큐 생성 (커스텀 비교를 통한 절댓값 힙 구현)
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
      int absA = Math.abs(a);
      int absB = Math.abs(b);
      // 1-1. 절댓값이 같으면 실제 값을 비교 (양수면 자리 바꿈)
      if (absA == absB) {
        return a - b;
      }
      // 1-2. 절댓값을 기준으로 비교
      return absA - absB;
    });

    // 2. 출력 값을 저장할 리스트 생성
    List<Integer> list = new ArrayList<>();

    // 3. 입력 배열 순회
    for (int x : arr) {
      // 3-1. 입력이 0이면 우선순위큐에서 가장 작은 절댓값을 가진 요소를 제거하고 리스트에 추가, 큐가 비어 있으면 0을 추가
      if (x == 0) {
        list.add(priorityQueue.isEmpty() ? 0 : priorityQueue.poll());
      }
      // 3-2. 입력값이 0이 아니면 우선순위큐에 데이터 추가
      else {
        priorityQueue.add(x);
      }
    }

    // 4. 리스트를 배열로 변환해서 반환
    int[] result = new int[list.size()];
    int num = 0;
    for (int i : list) {
      result[num++] = i;
    }
    return result;
  }

  public static void main(String[] args) {
    BOJ_11286 main = new BOJ_11286();
    // 입력값 예시
    // 18
    // 1, -1, 0, 0, 0, 1, 1, -1, -1, 2, -2, 0, 0, 0, 0, 0, 0, 0
    int n = 18;
    int[] arr = new int[]{1, -1, 0, 0, 0, 1, 1, -1, -1, 2, -2, 0, 0, 0, 0, 0, 0, 0};

    // 출력값 예시
    // -1, 1, 0, -1, -1, 1, 1, -2, 2, 0
    System.out.println("result = " + Arrays.toString(main.solution(arr)));
  }

}