package jaehoon.week02;

import java.util.Stack;

public class Lv02_올바른괄호 {

  boolean solution(String s) {
    Stack<Character> stack = new Stack<>();
    // 1. 문자열을 순회
    for (char ch : s.toCharArray()) {
      // 1-1. 만약 여는괄호면 stack에 추가
      if (ch == '(') {
        stack.push(ch);
      }
      // 1-2. 만약 닫는괄호면 stack에 여는괄호가 있는지 확인
      else {
        // 스택이 비어있거나, 여는괄호가 없다면 올바르지않은 괄호
        if (stack.isEmpty() || stack.pop() == ')') {
          return false;
        }
      }
    }
    // 2. 문자열을 다돌았는데, stack에 데이터가 남아있으면 안됨 (비어있으면 올바른괄호)
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Lv02_올바른괄호 main = new Lv02_올바른괄호();
    String str1 = "(())()";
    String str2 = ")()(";
    System.out.println("result1 = " + main.solution(str1));
    System.out.println("result1 = " + main.solution(str2));
  }
}