package jaehoon.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Lv02_괄호회전하기 {

  public int solution(String str) {
    int answer = 0;
    int n = str.length();

    // 1. StringBuilder를 사용하여 문자열 회전 처리
    StringBuilder sb = new StringBuilder(str);
    for (int i = 0; i < n; i++) {
      // 1-1. 올바른괄호 문자열이면 경우의 수 증가
      if (isCorrectParentheses(sb.toString())) {
        answer++;
      }
      // 1-2. 문자열 회전: 첫 문자 제거하고 마지막에 추가
      sb.append(sb.charAt(0));
      sb.deleteCharAt(0);
    }

    return answer;
  }

  // 올바른 괄호인지 확인하는 메서드
  public boolean isCorrectParentheses(String str) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char current = str.charAt(i);
      // 여는괄호면 스택에 추가
      if (current == '(' || current == '{' || current == '[') {
        stack.push(current);
      } else {
        // 닫는괄호인데, 스택이 비어있거나, 짝이 맞지 않으면 false를 리턴
        if (stack.isEmpty()) return false;
        char top = stack.pop();
        if ((current == ')' && top != '(') ||
            (current == '}' && top != '{') ||
            (current == ']' && top != '[')) {
          return false;
        }
      }
    }
    // 모든 문자열을 순회했는데, 스택이 비어있으면 올바른 괄호
    return stack.isEmpty();
  }

  public static void main(String[] args) throws IOException {
    Lv02_괄호회전하기 main = new Lv02_괄호회전하기();

    // 입력값 예시
    // "}]()[{"
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // 2
    System.out.println(main.solution(str));
  }
}
