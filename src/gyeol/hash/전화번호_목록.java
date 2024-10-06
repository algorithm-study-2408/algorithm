package gyeol.hash;

import java.util.Arrays;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42577
    효율성 검사 3, 4번 실패한 코드
 */
public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        // 1. 길이가 짧은 순서로 정렬
        Arrays.sort(phone_book, (s1, s2) -> s1.length() - s2.length());

        // 2. 확인
        String k1 = "a";
        String k2 = "b";
        int len = phone_book.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                k2 = phone_book[j];
                if (k2.startsWith(k1)) {
                    return false;
                }
            }
            k1 = phone_book[i];
        }

        return true;
    }
}
