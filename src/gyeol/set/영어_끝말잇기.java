package gyeol.set;

import java.util.HashSet;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int[] answer = {0, 0};
        set.add(words[0]);
        int len = words.length;
        for(int i = 1; i < len; i++) {
            int wordLen = words[i - 1].length();
            // 1. 끝말잇기가 제대로 안된 경우
            if(words[i - 1].charAt(wordLen - 1) != words[i].charAt(0)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }

            // 2. set에 add가 안된 경우
            if(!set.add(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
        }

        // 3. 아무 이상이 없는 경우
        return answer;
    }
}
