package jaehoon.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Lv02_짝지어제거하기 {

  public int solution(String s) {
    // 1. 문자열의 문자를 순서대로 스택에 넣어줌
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for(int i = 0; i < s.length(); i++) {
      // 1-1. 만약 스택이 비어있으면 문자를 스택에 넣어줌
      char ch = s.charAt(i);
      if(stack.isEmpty()) {
        stack.push(ch);
      }
      // 1-2. 스택이 비워져있지 않다면, 짝지어진 문자인지 확인
      // 스택에 저장된 가장최근에 삽입한 문자와 같은경우 스택의 문자제거 (짝맞음)
      else if (stack.peek() == ch) {
        stack.pop();
      }
      // 같은 문자가 아니면 스택에 추가로 문자 넣어줌
      else {
        stack.push(ch);
      }
    }
    // 2. 모든문자를 순회했을때, 스택이 비어 있다면, 짝이 모두 이루어졌기때문에 1 리턴, 남아있으면 0 리턴
    return stack.isEmpty() ? 1 : 0;
  }

  public static void main(String[] args) throws IOException {
    Lv02_짝지어제거하기 main = new Lv02_짝지어제거하기();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      // 입력값 예시
      // "baabaa"
      String str = br.readLine();

      // 출력값 예시
      // 1
      System.out.println(main.solution(str));
    } catch (IOException ioException) {
      System.out.println("ioException = " + ioException);
    }
  }
}
