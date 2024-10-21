package jaehoon.week08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lv03_다단계_칫솔_판매 {

  private static int BRUSH_PRICE = 100;

  private static Map<String, Integer> saleMap = new HashMap<>();

  public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    // 1. 부모노드를 가리키는 맵 생성
    Map<String, String> parentMap = new HashMap<>();
    for (int i = 0; i < enroll.length; i++) {
      parentMap.put(enroll[i], referral[i]);
    }
    System.out.println("parentMap = " + parentMap);

    // 2. 판매 계산 & 이익 분배
    for (int i = 0; i < seller.length; i++) {
      String currentName = seller[i];
      System.out.println("currentName = " + currentName);
      int price = amount[i] * 100;

      // 더이상 부모노드가 없을때까지 거슬러 올라가면서 이익분배
      while (!currentName.equals("-") && price > 0) {
        // 10% 계산
        saleMap.put(currentName, saleMap.getOrDefault(currentName, 0) + price - (price / 10));
        currentName = parentMap.get(currentName);
      }
    }

    // saleMap을 배열로 변환
    int[] arr = new int[enroll.length];
    for (int i = 0; i < enroll.length; i++) {
      arr[i] = saleMap.getOrDefault(enroll[i], 0);
    }
    return arr;
  }

  public static void main(String[] args) {
    String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}; // 판매자
    String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}; // 추천인
    String[] seller = {"young", "john", "tod", "emily", "mary"}; // 판매자
    int[] amount = {12, 4, 2, 5, 10}; // 판매개수

    int[] result = solution(enroll, referral, seller, amount);
    System.out.println("result = " + Arrays.toString(result));
  }

}
