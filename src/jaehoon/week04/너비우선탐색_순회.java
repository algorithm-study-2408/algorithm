package jaehoon.week04;

import java.util.*;

public class 너비우선탐색_순회 {

  // 인접한 노드를 저장할 리스트 배열
  static List<Integer>[] adj;

  // 방문을 기록할 배열
  static int[] visited;

  // 방문순서 결과를 저장할 리스트
  static List<Integer> answer;

  public int[] solution(int[][] graph, int start, int n) {
    // 인접리스트 초기화
    adj = new ArrayList[n + 1];
    for (int i = 0; i < adj.length; i++) {
      adj[i] = new ArrayList<>();
    }

    // 방문을 기록할 배열 초기화
    visited = new int[n + 1];

    // 방문순서를 저장할 리스트 초기화
    answer = new ArrayList<>();

    // 간선 연결
    for (int[] g : graph) {
      addEdge(g[0], g[1]);
    }

    bfs(start);
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

  // 간선을 연결하는 메서드
  private void addEdge(int v, int w) {
    adj[v].add(w); // 정점 v의 인접 리스트에 정점 w를 추가
  }

  void bfs(int start) {
    Queue<Integer> queue = new ArrayDeque<>();
    visited[start] = 1;
    queue.add(start);
    while (queue.size() > 0) {
      int now = queue.poll();
      answer.add(now);
      for (int v : adj[now]) {
        if (visited[v] == 0) {
          queue.add(v);
          visited[v] = visited[now] + 1;
        }
      }
    }

  }

  public static void main(String[] args) {
    너비우선탐색_순회 main = new 너비우선탐색_순회();

    // 입력값 예시 1
    int[][] graph1 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}};
    int start1 = 1;
    int n1 = 9;

    // 출력값 예시 1
    // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    System.out.println(Arrays.toString(main.solution(graph1, start1, n1)));

    // 입력값 예시 2
    int[][] graph2 = {{1, 3}, {3, 4}, {3, 5}, {5, 2}};
    int start2 = 1;
    int n2 = 5;

    // 출력값 예시 1
    // [1, 3, 4, 5, 2]
    System.out.println(Arrays.toString(main.solution(graph2, start2, n2)));
  }
}
