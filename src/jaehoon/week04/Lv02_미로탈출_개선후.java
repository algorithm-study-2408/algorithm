package jaehoon.week04;

import java.util.ArrayDeque;

public class Lv02_미로탈출_개선후 {

  // 방향 배열 (상, 우, 하, 좌)
  static int[] dy = {-1, 0, 1, 0};
  static int[] dx = {0, 1, 0, -1};

  public int solution(String[] maps) {
    int n = maps.length;
    int m = maps[0].length();

    // 1. 시작, 레버, 출구 위치 찾기
    int[] start = new int[2];
    int[] lever = new int[2];
    int[] exit = new int[2];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char c = maps[i].charAt(j);
        if (c == 'S') start = new int[]{i, j};
        else if (c == 'L') lever = new int[]{i, j};
        else if (c == 'E') exit = new int[]{i, j};
      }
    }

    // 2. S -> L까지 최단 거리 구함
    int leverTime = bfs(maps, start, lever, n, m);
    if (leverTime == -1) return -1; // 레버까지 갈 수 없으면 -1 반환

    // 3. L -> E까지 최단 거리 구함
    int exitTime = bfs(maps, lever, exit, n, m);
    if (exitTime == -1) return -1; // 출구까지 갈 수 없으면 -1 반환

    // 4. 전체 시간은 레버까지의 시간 + 출구까지의 시간
    return leverTime + exitTime;
  }

  // BFS 함수: 시작점(start)에서 목표점(end)까지의 최단 거리를 계산
  private int bfs(String[] maps, int[] start, int[] end, int n, int m) {
    int[][] dis = new int[n][m]; // 최단 거리를 기록할 배열 초기화
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.add(start);
    dis[start[0]][start[1]] = 1;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int y = now[0];
      int x = now[1];

      // 목표점에 도달하면 최단 거리 반환
      if (y == end[0] && x == end[1]) {
        return dis[y][x] - 1;
      }

      // 4방향 탐색
      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        // 유효 범위 & 벽(X) 확인
        if (ny >= 0 && nx >= 0 && ny < n && nx < m
            && maps[ny].charAt(nx) != 'X'
            && dis[ny][nx] == 0) {
          dis[ny][nx] = dis[y][x] + 1; // 최단 거리 갱신
          queue.add(new int[]{ny, nx});
        }
      }
    }

    return -1; // 탐색을 마칠때까지 목표점에 도달하지 못하면 -1 반환
  }

  public static void main(String[] args) {
    Lv02_미로탈출_개선후 main = new Lv02_미로탈출_개선후();

    // 테스트 케이스 1
    String[] arr1 = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
    System.out.println("result = " + main.solution(arr1)); // 예상 출력: 16

    // 테스트 케이스 2
    String[] arr2 = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
    System.out.println("result = " + main.solution(arr2)); // 예상 출력: -1
  }
}
