package jaehoon.week04;

import java.util.ArrayDeque;
import java.util.Queue;
 // 남서북동
public class BOJ_2178 {

  // 방문을 기록할 배열 (최단거리 저장)
  static int[][] visited;

  // x, y 이동 좌표 (오 -> 아래 -> 왼 -> 위)
  static int[] dx = {1, 0, -1, 0};

  static int[] dy = {0, 1, 0, -1};

  public int solution(int[][] graph, int n, int m) {
    // 방문기록 초기화 (0-based 인덱스 처리)
    visited = new int[n][m];

    // BFS
    bfs(graph, 0, 0, n, m);

    // 도착지점의 최단거리 반환
    return visited[n - 1][m - 1];
  }

  private void bfs(int[][] graph, int startX, int startY, int n, int m) {
    Queue<int[]> q = new ArrayDeque<>();
    visited[startX][startY] = 1;  // 시작 지점 방문 처리
    q.add(new int[]{startX, startY});

    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];

      // 상하좌우 탐색
      for (int dir = 0; dir < 4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        // 경계를 벗어나면 무시
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }

        // 이미 방문했거나, 이동할 수 없는 곳이면 무시
        if (visited[nx][ny] > 0 || graph[nx][ny] != 1) {
          continue;
        }

        // 거리 갱신 및 큐에 삽입
        visited[nx][ny] = visited[x][y] + 1;
        q.add(new int[]{nx, ny});
      }
    }
  }

  public static void main(String[] args) {
    BOJ_2178 main = new BOJ_2178();
    // 입력값 예시
    // 4
    // 6
    // 101111
    // 101010
    // 101011
    // 111011
    int n = 4;
    int m = 6;
    int[][] graph = {
        {1, 0, 1, 1, 1, 1},
        {1, 0, 1, 0, 1, 0},
        {1, 0, 1, 0, 1, 1},
        {1, 1, 1, 0, 1, 1}
    };

    // 출력값 예시
    // 15
    System.out.println("result = " + main.solution(graph, n, m));
  }
}
