package jaehoon.week04;

public class Lv02_네트워크 {

  // 인접행렬로 구현된 컴퓨터 그래프
  static int[][] computers;

  // 방문을 기록할 변수
  static boolean[] visited;

  public int solution(int n, int[][] computers) {
    // 1. 네트워크 개수를 저장할 변수 초기화
    int result = 0;

    // 2. 컴퓨터 그래프 & 방문을 기록할 변수 초기화
    this.computers = computers;
    visited = new boolean[computers.length];

    // 3. n개의 노드를 순회
    for (int i = 0; i < n; i++) {
      // 3-1. 방문하지 않았다면 dfs 탐색
      if (!visited[i]) {
        dfs(i);
        result++; // DFS 탐색이 모두 끝났다면 네트워크 개수 추가
      }
    }
    return result;
  }

  public void dfs(int now) {
    // 기저조건
    if (visited[now]) return;
    // 방문 기록 & 네트워크 횟수 추가
    visited[now] = true;
    // 인접한 노드 확인
    for (int i = 0; i < computers[now].length; i++) {
      // 방문한 노드이면 무시 (자기자신은 1로 되어있지만 이미 방문처리 했으므로 dfs가 돌지 않음)
      // 연결된 노드이면서 방문하지 않은 노드라면 DFS 탐색
      if (computers[now][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }

  public static void main(String[] args) {
    Lv02_네트워크 main = new Lv02_네트워크();
    // 입력값 예시:
    // 3
    // {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}
    int n = 3;
    int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    // 출력값 예시:
    // 2
    System.out.println("result = " + main.solution(n, computers));
  }
}
