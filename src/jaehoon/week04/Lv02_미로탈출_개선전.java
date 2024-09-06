package jaehoon.week04;

import java.util.ArrayDeque;

public class Lv02_미로탈출_개선전 {

  static int[] dy = {-1, 0, 1, 0};

  static int[] dx = {0, 1, 0, -1};

  public int solution(String[] maps) {
    // 1. 레버까지 최적 시간을 저장할 변수
    int leverTime = 0;
    int[] leverPosition = new int[2];

    // 2. 빠져나가는 문까지 최적 시간을 저장할 변수
    int doorTime = 0;
    int[] doorPosition = new int[2];


    int n = maps.length;

    int m = maps[0].length();

    // 3. 최단 시간을 저장할 배열
    int[][] dis = new int[n][m];

    // 4. 스타트 위치 찾기
    int[] start = new int[2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (maps[i].charAt(j) == 'S') {
          start[0] = i;
          start[1] = j;
        }
      }
    }

    // 5. 스타트 위치 부터 레버로 이동하는 최적시간을 구함 (BFS)
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.addLast(start);
    dis[start[0]][start[1]] = 1;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int y = now[0];
      int x = now[1];
      // 큐에서 빼서 인접한 위치 확인
      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        // 범위 넘어갔는지 경계값 확인
        if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

        // 벽이면 무시
        if (maps[ny].charAt(nx) == 'X') continue;

        // 방문하지 않았으면 최단거리 갱신 & 큐 삽입
        if (dis[ny][nx] == 0) {
          dis[ny][nx] = dis[y][x] + 1; // 기존 거리에 + 1

          // 만약에 레버를 찾으면 최단거리 저장하고 BFS 종료
          if (maps[ny].charAt(nx) == 'L') {
            leverTime = dis[ny][nx];
            leverPosition[0] = ny;
            leverPosition[1] = nx;
            queue.clear(); // 큐 초기화
            dis = new int[n][m]; // 최단거리 초기화
            break;
          }
          queue.addLast(new int[]{ny, nx});
        }
      }
    }

    // 레버까지 도달하지 못하는 경우 -1 리턴
    if (leverTime == 0) {
      return -1;
    }

    // 6. 레버위치부터 빠져나가는 문까지 이동하는 최적시간 구함 (BFS)
    queue.addLast(new int[]{leverPosition[0], leverPosition[1]});
    dis[leverPosition[0]][leverPosition[1]] = 1;
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int y = now[0];
      int x = now[1];
      // 큐에서 빼서 인접한 위치 확인
      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        // 범위 넘어갔는지 경계값 확인
        if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

        // 벽이면 무시
        if (maps[ny].charAt(nx) == 'X') continue;

        // 방문하지 않았으면 최단거리 갱신 & 큐 삽입
        if (dis[ny][nx] == 0) {
          dis[ny][nx] = dis[y][x] + 1; // 기존 거리에 + 1

          // 만약에 출구를 찾으면 최단거리 저장하고 BFS 종료
          if (maps[ny].charAt(nx) == 'E') {
            doorTime = dis[ny][nx];
            doorPosition[0] = ny;
            doorPosition[1] = nx;
            queue.clear(); // 큐 초기화
            break;
          }
          queue.addLast(new int[]{ny, nx});
        }
      }
    }

    // 출구까지 도달하지 못하는 경우 -1 리턴
    if (doorTime == 0) {
      return -1;
    }

    // 8. (레버시간 + 출구시간) -2
    // start를 1부터 시작, lever 1부터 시작하므로 -2 해줌
    return leverTime + doorTime - 2;
  }

  public static void main(String[] args) {
    Lv02_미로탈출_개선전 main = new Lv02_미로탈출_개선전();

    // 입력값 예시:
    // {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}
    String[] arr1 = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};

    // {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}
    String[] arr2 = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};

    // 출력값 예시:
    // 16
    System.out.println("result = " + main.solution(arr1));
    System.out.println("result = " + main.solution(arr2));
  }
}