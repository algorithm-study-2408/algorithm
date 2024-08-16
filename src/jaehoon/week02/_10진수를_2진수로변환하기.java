package jaehoon.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10진수를_2진수로변환하기 {

  public String solution(int decimal) {
    Stack<Integer> stack = new Stack<>();
    while (decimal > 0) {
      stack.push(decimal % 2);
      decimal /= 2;
    }
    StringBuilder str = new StringBuilder();
    while (!stack.isEmpty()) {
      str.append(stack.pop());
    }

    return str.toString();
  }

  public static void main(String[] args) throws IOException {
    _10진수를_2진수로변환하기 main = new _10진수를_2진수로변환하기();

    // 입력값 예시
    // 12345
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int decimal = Integer.parseInt(br.readLine());

    // 출력값 예시
    // 11000000111001
    System.out.println(main.solution(decimal));
  }
}
