package gyeol.set;

import java.util.HashSet;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        // 1. set생성
        for(int num : nums) {
            set.add(num);
        }
        int size = set.size();
        // 2-1. set보다 길이가 더 길면 set 반환
        if (len > size) {
            answer = size;
            // 2-2. len길이가 더 길면 len 반환
        } else {
            answer = len;
        }
        return answer;
    }
}
