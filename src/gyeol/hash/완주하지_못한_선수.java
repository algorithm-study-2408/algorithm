package gyeol.hash;

import java.util.HashMap;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            // 1. putIfAbsent 참가자들을 기본적으로 0이라는 값을 가지게끔 map으로 만듦
            // putIfAbsent 존재하면 기존 값을 건들지 않음
            map.putIfAbsent(p, 0);
            // 2. participant 배열을 computeIfPresent를 사용해서 존재하는 참가자면 value를 1씩 증가하게 하여 map으로 만든다.
            map.computeIfPresent(p, (k, v) -> v + 1);
        }

        // 3. participantMap에 completion 배열에 해당하는 이름이 있으면 value를 -1씩 한다.
        for (String c : completion) {
            map.computeIfPresent(c, (k, v) -> v - 1);
        }

        // 4. value가 1인 key값을 찾는다.
        for (String m : map.keySet()) {
            if (map.get(m) == 1) {
                answer = m;
                break;
            }
        }
        return answer;
    }
}
