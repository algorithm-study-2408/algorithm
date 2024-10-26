package jaehoon.week09;

import java.util.HashSet;

public class Lv01_폰켓몬 {

  public static int solution(int[] nums) {
    // 1. 받을 수 있는 폰켓몬의 수
    int count = nums.length / 2;

    // 2. nums를 순회하면서 set에 데이터를 추가
    HashSet<Integer> mon = new HashSet<>();
    for (int num : nums) {
      mon.add(num);
    }

    // 3. 고유한 폰켓몬 종류의 수와 count 중 작은 값을 반환
    return (Math.min(count, mon.size()));
  }

  public static void main(String[] args) {
    int[] nums = {3, 3, 3, 2, 2, 4};

    int result = solution(nums);
    System.out.println("result = " + result);
  }
}
