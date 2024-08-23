package jaehoon.week03;

import java.util.ArrayDeque;

public class Lv01_카드뭉치 {

  public String solution(String[] cards1, String[] cards2, String[] goal) {
    // 1. 카드1 뭉치, 카드2 뭉치를 각 큐 자료구조에 넣음
    ArrayDeque<String> q1 = new ArrayDeque<>();
    ArrayDeque<String> q2 = new ArrayDeque<>();
    for (String card : cards1) q1.addLast(card);
    for (String card : cards2) q2.addLast(card);

    // 2. 원하는 단어 배열(goal)을 순회
    for (String str : goal) {
      // 2-1. 카드1, 카드2 큐의 맨앞의 요소가 원하는 단어에 해당하는지 확인
      if (!q1.isEmpty() && q1.peek().equals(str)) {
        q1.pollFirst();
      } else if (!q2.isEmpty() && q2.peek().equals(str)) {
        q2.pollFirst();
      } else {
        return "No";
      }
    }
    return "Yes";
  }

  public static void main(String[] args) {
    Lv01_카드뭉치 main = new Lv01_카드뭉치();

    // 입력값 예시
    String[] cards1 = {"i", "water", "drink"};
    String[] cards2 = {"want", "to"};
    String[] goal = {"i", "want", "to", "drink", "water"};

    // 출력값 예시
    // "No"
    System.out.println("result = " + main.solution(cards1, cards2, goal));
  }
}
