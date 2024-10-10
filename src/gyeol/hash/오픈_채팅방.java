package gyeol.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */
public class 오픈_채팅방 {
    public String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>(); // 유저 맵
        List<String> answer = new ArrayList<>();

        // user맵 생성
        for(String r : record) {
            // 1. 띄어쓰기 기준으로 배열 생성
            String[] recordArr = r.split(" ");
            // 2-1. Enter인 경우
            if(recordArr[0].equals("Enter")) {
                userMap.put(recordArr[1], recordArr[2]);
                // 2-2. Change인 경우
            } else if(recordArr[0].equals("Change")) {
                userMap.put(recordArr[1], recordArr[2]);
            }
        }

        for(String r : record) {
            // 1. 띄어쓰기 기준으로 배열 생성
            String[] recordArr = r.split(" ");
            // 2-1. Enter인 경우
            if(recordArr[0].equals("Enter")) {
                answer.add(userMap.get(recordArr[1]) + "님이 들어왔습니다.");
                // 2-2. Leave인 경우
            } else if(recordArr[0].equals("Leave")) {
                answer.add(userMap.get(recordArr[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
