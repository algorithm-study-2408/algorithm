package gyeol.tree;

import java.util.Arrays;

/*
    이분탐색 문제
    https://school.programmers.co.kr/learn/courses/30/lessons/43238
 */
public class 입국심사 {
    public long solution(int n, int[] times) {
        // 1. 오름차순 정렬
        Arrays.sort(times);

        // 2. 시작 끝 값
        long end = Long.MAX_VALUE;
        long start = 1;

        // 3. 이진 탐색
        while (start < end) {
            long mid = start + (end - start) / 2;
            long sum = 0; // 주어진 시간 동안 검사할 수 있는 사람의 수

            // 4. 주어진 시간(mid) 동안 검사할 수 있는 사람의 수 계산
            for (int time : times) {
                sum += mid / time;
                // 모든 사람을 검사할 수 있으면 더 계산할 필요 없음
                if (sum >= n) break;
            }

            // 5. 이진 탐색 조건
            if (sum >= n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
