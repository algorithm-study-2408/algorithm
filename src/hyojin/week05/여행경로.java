package hyojin.week05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 여행경로 {
    private static HashMap<String, PriorityQueue<String>> map;
    private static ArrayList<String> result;

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        int n = tickets.length;

        // 인접 리스트 초기화 (출발지 -> 도착지 리스트)
        map = new HashMap<>();
        for (String[] ticket : tickets) {
            String dep = ticket[0];
            String des = ticket[1];

            // 도착지를 우선순위 큐로 관리 (알파벳 순으로 자동 정렬)
            map.putIfAbsent(dep, new PriorityQueue<>());    // 새로 배운 메서드!
            map.get(dep).offer(des);
        }

        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        result = new ArrayList<>();
        dfs("ICN");

        // 결과 출력
        System.out.println("======================");
        System.out.println(result);
        System.out.println("======================");
        String[] answer = result.toArray(new String[0]);
        for (String s : answer) {
            System.out.println("s = " + s);
        }
    }

    private static void dfs(String start) {
        // key마다 valu 별로 방문기록을 확인한다?
        // PriorityQueue의 queue의 특성을 이용해서 값을 제외한다(poll)
        result.add(start);
        PriorityQueue<String> strings = map.get(start);
        if (strings != null &&!strings.isEmpty()) {
            String next = strings.poll();
            dfs(next);
        } else {
             if (strings != null && strings.size() != 0) {
                result.add(String.valueOf(strings));
             }
        }

    }
}
