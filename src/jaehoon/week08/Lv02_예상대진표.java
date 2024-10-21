package jaehoon.week08;

// https://school.programmers.co.kr/learn/courses/30/lessons/12985
public class Lv02_예상대진표 {

  public static int solution(int n, int a, int b) {
    // 1. 라운드를 카운트할 변수선언
    int answer = 0;
    // 2. a와 b의 번호가 같아질 때까지 라운드 증가
    for (; a != b; answer++) {
      // 2-1. 새로운 번호 부여 (N-1 or N -> +1 -> /2 연산)
      a = (a + 1) / 2;
      b = (b + 1) / 2;
    }
    return answer;
  }

  public static void main(String[] args) {
    // 입력 예시:
    // 8
    // 4
    // 7
    int n = 8;
    int a = 4;
    int b = 7;

    // 출력 예시:
    // 3
    System.out.println(solution(n, a, b));
  }
}
