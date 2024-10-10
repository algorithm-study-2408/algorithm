package gyeol.hash;

import java.util.HashMap;
import java.util.Map;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        // 1. map<의상 종류, 갯수> 생성
        for (String[] c : clothes) {
            map.compute(c[1], (k, v) -> v == null ? 1 : v + 1);
        }

        int multiply = 1;
        for (String k : map.keySet()) {
            multiply *= map.get(k) + 1;
        }
        answer += (multiply - 1);

        return answer;
    }
}
