package hyojin.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 프로그래머스_의상 {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution(clothes);
        System.out.println(result);
    }

    private static int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (String[] c : clothes) {
            String category = c[1];
            String item = c[0];
            // 카테고리 아이템 추가
            hashMap.putIfAbsent(category, new ArrayList<>());
            hashMap.get(category).add(item);
        }

        // 카테고리별 아이템 조합을 계산하는 방식
        int result = 1;
        for (ArrayList<String> list : hashMap.values()) {
            result *= (list.size() + 1); // 각 카테고리에서 의상을 선택하지 않는 경우도 고려
        }

        return result - 1; // 아무것도 입지 않는 경우를 제외
    }
}
