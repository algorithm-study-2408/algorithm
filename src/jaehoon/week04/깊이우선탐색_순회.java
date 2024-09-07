package jaehoon.week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 깊이우선탐색_순회 {

  // 인접한 노드를 저장할 리스트 배열
  static List<Integer>[] adj;

  // 방문을 기록할 배열
  static boolean[] visited;

  // 방문순서 결과를 저장할 리스트
  static List<Integer> answer;


  public int[] solution(int[][] graph, int start, int n) {
    // 1. 리스트 배열 초기화
    adj = new ArrayList[n + 1];
    for (int i = 0; i < adj.length; i++) {
      adj[i] = new ArrayList<>();
    }

    // 2. 방문을 기록할 배열 초기화
    visited = new boolean[n + 1];

    // 3. 방문순서 결과를 저장할 리스트 초기화
    answer = new ArrayList<>();

    // 4. graph(v, w)를 인접리스트에 저장
    for (int[] g : graph) {
      addEdge(g[0], g[1]);
    }

    // 5. 시작노드부터 dfs 탐색
    dfs1(start);
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

  // 간선을 연결하는 메서드
  private void addEdge(int v, int w) {
    adj[v].add(w); // 정점 v의 인접 리스트에 정점 w를 추가
  }

  // 방법1: 못먹어도 고 (dfs호출하고 방문했는지 확인)
  private void dfs1(int v) {
    if (visited[v]) return;
    visited[v] = true;
    answer.add(v);
    for (int there : adj[v]) {
      dfs1(there);
    }
  }

  // 방법2: 돌다리도 두들겨보고 건너라 (방문했는지 확인하고 dfs)
  private void dfs2(int v) {
    visited[v] = true;
    answer.add(v);
    for (int there : adj[v]) {
      if (!visited[there]) {
        dfs2(there);
      }
    }
  }

  public static void main(String[] args) {
    깊이우선탐색_순회 main = new 깊이우선탐색_순회();

    // 입력값 예시 1
    int[][] graph1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
    int start1 = 1;
    int n1 = 5;

    // 출력값 예시 1
    // [1, 2, 3, 4, 5]
    System.out.println(Arrays.toString(main.solution(graph1, start1, n1)));

    // 입력값 예시 2
    int[][] graph2 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}};
    int start2 = 1;
    int n2 = 6;

    // 출력값 예시 2
    // [1, 2, 4, 5, 6, 3]
    System.out.println(Arrays.toString(main.solution(graph2, start2, n2)));
  }
}
