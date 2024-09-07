package jaehoon.week04;

public class Lv02_타겟넘버 {

  static int count = 0;

  public int solution(int[] numbers, int target) {
    recursive(numbers, target, 0, 0);
    return count;
  }

  private void recursive(int[] numbers, int target, int curLevel, int sum) {
    // 기저조건: 만약 그래프의 레벨이 5이면 종료
    if (curLevel == numbers.length) {
      // target과 값이 같으면 경우의 수 증가
      if (sum == target) {
        count++;
      }
      return;
    }
    recursive(numbers, target, curLevel + 1, sum + numbers[curLevel]);
    recursive(numbers, target, curLevel + 1, sum - numbers[curLevel]);
  }

  public static void main(String[] args) {
    Lv02_타겟넘버 main = new Lv02_타겟넘버();

    // 입력값 예시:
    int[] numbers = {4, 1, 2, 1};
    int target = 4;

    // 출력값 예시:
    // 2
    System.out.println("result = " + main.solution(numbers, target));
  }
}
