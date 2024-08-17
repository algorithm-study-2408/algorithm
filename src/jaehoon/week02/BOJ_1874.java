package jaehoon.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_1874 {

  public String solution(int[] numbers) {
    int lastNumber = 0; // 마지막으로 스택에 저장한 숫자를 저장할 변수
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    StringBuilder result = new StringBuilder();

    // 1. 숫자수열 순회
    for (int num : numbers) {
      // 1-1. num까지의 숫자를 스택에 push하고, '+'를 기록
      if (lastNumber < num) {
        for (int i = lastNumber + 1; i <= num; i++) {
          stack.push(i);
          result.append("+\n");
        }
        lastNumber = num;
      }
      // 1-2. 만약 스택의 맨위 숫자를 꺼내야하는 상황인데, 스택의 맨 위 숫자와 입력된 숫자가 다르면 "NO" 리턴
      else if (!(stack.peek() == num)) {
        return "NO\n";
      }
      // 1-3. 스택에서 pop하고 '-'를 기록
      stack.pop();
      result.append("-\n");
    }

    // 2. +-가 저장된 문자열 리턴
    return result.toString();
  }

  public static void main(String[] args) {
    BOJ_1874 main = new BOJ_1874();

    // 입력값 예시
    //    8
    //    4
    //    3
    //    6
    //    8
    //    7
    //    5
    //    2
    //    1
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(bufferedReader.readLine());
      int[] numbers = new int[n];
      for (int i = 0; i < n; i++) {
        numbers[i] = Integer.parseInt(bufferedReader.readLine());
      }

      // solution 메서드 호출
      String result = main.solution(numbers);
      System.out.println(result);


    } catch (IOException ioException) {
      System.out.println("ioException = " + ioException);
    }
  }
}
