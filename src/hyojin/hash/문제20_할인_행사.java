package hyojin.hash;

import java.util.HashMap;

public class 문제20_할인_행사 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int result = solution(want, number, discount);
        System.out.println("result = " + result);
    }

    private static int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        int answer = 0;

        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> discount10d = new HashMap<>();

            for (int j = i; j < i + 10; j++) {
//                if (wantMap.containsKey(discount[j])) {
//                    discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
//                }

                // compute 메서드 사용시
                discount10d.compute(discount[j], (key, value) -> value == null ? 1 : value + 1);
            }

            if (discount10d.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }
}
