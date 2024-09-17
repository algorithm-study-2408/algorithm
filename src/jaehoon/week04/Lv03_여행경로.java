package jaehoon.week04;

import java.util.*;

public class Lv03_여행경로 {

  public static List<String> solution(String[][] tickets) {
    // 경로를 저장할 리스트
    List<String> result = new ArrayList<>();

    // 항공권 정보를 저장할 맵 (출발도시, 방문이 가능한 도시 리스트)
    Map<String, PriorityQueue<String>> flightMap = new HashMap<>();

    // 티켓 정보를 flightMap에 저장
    for (String[] ticket : tickets) {
      String dep = ticket[0];
      String des = ticket[1];
      // flightMap에 키값(출발도시)이 없으면 방문이 가능한 도시 리스트(우선순위 큐) 초기화
      flightMap.computeIfAbsent(dep, k -> new PriorityQueue<>())
               .add(des);
    }

    // DFS 실행
    dfs("ICN", flightMap, result);

    // 경로가 역순으로 저장되므로, 순서를 반대로 변경
    Collections.reverse(result);
    return result;
  }

  private static void dfs(String airport, Map<String, PriorityQueue<String>> flightMap, List<String> result) {
    // 방문할 수 있는 도착지 리스트(arrivals)를 가져오기
    PriorityQueue<String> arrivals = flightMap.get(airport);

    // 도착지 리스트가 존재하고 비어있지 않으면
    // 현재 공항에서 갈 수 있는 모든 공항을 사전순으로 방문
    while (arrivals != null && !arrivals.isEmpty()) {
      // 사전순으로 우선순위 큐에서 첫 번째 도착지로 DFS 실행
      String city = arrivals.poll(); // 큐에서 첫 번째 도착지를 가져옴
      dfs(city, flightMap, result);
    }

    // 더 이상 방문할 공항이 없으면 현재 공항을 경로에 추가 -> dfs 함수는 "백트래킹" 됨
    result.add(airport);
  }

  public static void main(String[] args) {
    // 테스트 케이스 1
    String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
    System.out.println(solution(tickets1));

    System.out.println();

    // 테스트 케이스 2
    String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
    System.out.println(solution(tickets2));
  }
}
