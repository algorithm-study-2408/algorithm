package hyojin.hash;

import java.util.Arrays;

/**
 *  프로그래머스
 *  해시/Lv2/전화번호 목록
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */

public class 프로르개머스_전화번호_목록 {
    public static void main(String[] args) {
        // 테스트 케이스
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};

        // 결과 출력
        System.out.println(solution(phone_book1)); // false
        System.out.println(solution(phone_book2)); // true
        System.out.println(solution(phone_book3)); // false
    }

    private static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
