package jaehoon.week04;

import java.util.ArrayDeque;

public class Lv02_게임_맵_최단거리 {

  private static final int[] dy = {-1, 0, 1, 0};

  private static final int[] dx = {0, 1, 0, -1};

  public int solution(int[][] maps) {
    // 1. 거리를 기록할 배열 초기화 (map 크기 만큼)
    int n = maps.length;
    int m = maps[0].length;
    int[][] dist = new int[n][m];

    // 1. 시작 노드를 큐에 삽입 & 거리 저장
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.addLast(new int[]{0, 0});
    dist[0][0] = 1;

    // 2. 큐가 빌때까지 반복 (더이상 방문하지 못할때까지 BFS)
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int y = cur[0];
      int x = cur[1];

      // 2-1. 인접한 4방향 순회
      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        // 2-2. 맵 밖으로 나가는 경계값 처리
        if (ny < 0 || nx < 0 || ny >= maps.length || nx >= maps[0].length) continue;

        // 2-4. 벽이 막혀있으면 무시
        if (maps[ny][nx] == 0) continue;

        // 2-5. 처음 방문하는 경우 (큐에 추가 & 거리 갱신)
        if (dist[ny][nx] == 0) {
          dist[ny][nx] = dist[y][x] + 1; // 방문한 노드 거리 갱신
          queue.addLast(new int[]{ny, nx}); // 방문한 노드 큐에 추가
        }
      }
    }


    int result = dist[n - 1][m - 1];
    return (result == 0) ? -1 : result; // 상대진영에 방문하지 못하면 -1 리턴
  }

  public static void main(String[] args) {
    Lv02_게임_맵_최단거리 main = new Lv02_게임_맵_최단거리();
    // 입력값 예시:
    // {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}}
    int[][] maps = {
        {1, 0, 1, 1, 1},
        {1, 0, 1, 0, 1},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 0, 1},
        {0, 0, 0, 0, 1}
    };

    // 출력값 예시:
    // 11
    System.out.println("result = " + main.solution(maps));
  }

}
