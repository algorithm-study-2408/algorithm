package jaehoon.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 요세푸스문제 {

  public int solution(int n, int k) {
    // 1. 1부터 N까지 큐에 데이터 삽입
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      queue.add(i);
    }

    // 2. 큐에 1명의 사람이 남을때까지 2, 3번 반복하고 1명이 남으면 반환
    while (queue.size() > 1) {
      // 2-1. 큐의 front를 기준으로 k-1번 큐에서 빼주고 다시 넣어주는 작업수행
      for (int i = 0; i < (k - 1); i++) {
        Integer temp = queue.poll();
        queue.add(temp);
      }
      // 2-2. k번째 사람 없앰
      queue.poll();
    }

    // 4. 큐에 1명의 사람이 남으면 해당사람의 번호를 반환
    return queue.poll();
  }

  public static void main(String[] args) throws IOException {
    요세푸스문제 main = new 요세푸스문제();

    // 입력값 예시
    // 5
    // 2
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    // 출력값 예시
    // 3
    System.out.println("result = " + main.solution(n, k));
  }
}
