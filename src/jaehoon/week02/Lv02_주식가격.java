package jaehoon.week02;

import java.util.*;
import java.io.*;

public class Lv02_주식가격 {

  public int[] solution(int[] prices) {
    int n = prices.length;
    int[] answer = new int[n]; // 결과를 저장할 배열
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    // 1. 주식가격 배열(prices)의 인덱스를 순회
    for (int i = 0; i < n; i++) {
      // 1-1. 스택에 있는 값들과 현재 가격을 비교
      // - 이전 주식가격이 현재 시점에 떨어졌으면, 스택에서 제거하고 얼마만에 떨어졌는지 기록
      // - 스택 맨 위에 있는 값이 가격이 떨어졌으면 다른 주식가격도 떨어졌을 수 있음
      // - 스택에 저장된 다른 주식가격도 while문을 통해 현재시점에서 떨어졌는지 확인 (가격이 떨어지지 않으면 스택에 계속 저장되어 있음)
      while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
        int index = stack.pop();
        answer[index] = i - index; // 가격이 떨어지기 전까지의 시간을 저장
      }
      // 1-2. 현재 주식의 인덱스를 스택에 저장
      stack.push(i);
    }

    // 2. 스택에 남아 있는 인덱스는 가격이 끝까지 떨어지지 않은 경우
    while (!stack.isEmpty()) {
      int index = stack.pop();
      // 2-1. 마지막 주식 가격의 인덱스(n-1) - 끝까지 가격이 떨어지지않은 주식의 인덱스 = 가격이 끝까지 떨어지지 않은 시간
      answer[index] = (n - 1) - index;
    }

    return answer;
  }

  public static void main(String[] args) {
    Lv02_주식가격 main = new Lv02_주식가격();
    // 입력값 예시
    // 1, 2, 3, 2, 3
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int[] prices = Arrays.stream(br.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
      // 출력값 예시
      // 4, 3, 1, 1, 0
      System.out.println("result = " + Arrays.toString(main.solution(prices)));
    } catch (IOException ioException) {
      System.out.println("ioException = " + ioException);
    }
  }
}
