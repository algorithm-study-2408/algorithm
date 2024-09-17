package jaehoon.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11780_플로이드2 {

  // 무한대 숫자
  static final int INF = 0x3f3f3f3f;

  // 최단거리를 저장할 배열
  static int[][] d = new int[105][105];

  // 경로 추적을 위한 배열
  static int[][] nxt = new int[105][105];

  // 도시, 버스의 수
  static int n, m;

  public static void main(String[] args) {

/*
입력값 예시 :
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
*/
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      n = Integer.parseInt(br.readLine()); // 도시의 수
      m = Integer.parseInt(br.readLine()); // 버스의 수

      // 거리 배열을 INF로 초기화
      for (int i = 1; i <= n; i++) {
        Arrays.fill(d[i], INF);
      }

      // 입력받은 버스 정보로 최소 비용을 d에 저장하고 경로 정보를 nxt에 기록
      for (int i = 0; i < m; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 시작 도시
        int b = Integer.parseInt(st.nextToken()); // 도착 도시
        int c = Integer.parseInt(st.nextToken()); // 비용
        // 더 작은 비용의 버스만 저장
        d[a][b] = Math.min(d[a][b], c);
        nxt[a][b] = b;// a에서 b로 바로 가는 경로를 저장
      }

      // 자기 자신으로 가는 경로는 비용이 0
      for (int i = 1; i <= n; i++) {
        d[i][i] = 0;
      }

      // 플로이드-와샬 알고리즘
      // 바로 s -> t로 가는 경로보다 k를 거쳐가는 경로가 빠른지 확인 (중간에 거쳐가게끔 할 원소를 3중 for문에 가장 바깥에 두어야 함)
      for (int k = 1; k <= n; k++) { // 경유지
        for (int i = 1; i <= n; i++) { // 출발지
          for (int j = 1; j <= n; j++) { // 도착지
            if (d[i][j] > d[i][k] + d[k][j]) {
              d[i][j] = d[i][k] + d[k][j]; // 최단거리 갱신
              nxt[i][j] = nxt[i][k]; // 경로를 갱신
            }
          }
        }
      }

      // 도시 간의 최소 비용 출력
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (d[i][j] == INF) {
            System.out.print("0 ");
          } else {
            System.out.print(d[i][j] + " ");
          }
        }
        System.out.println();
      }

      // 최소 비용 경로 정보 출력
      /*
       * 1. i에서 j로 갈 수 없거나 무한대 인경우: 0을 출력
       * 2. i에서 j로 가는 경로가 존재할 경우:
       *    - 경로에 포함된 도시의 개수 k를 출력하고,
       *    - 그 다음에 경로에 포함된 도시들을 출력 (시작도시(i) -> 도착도시(j))
       */
      for (int i = 1; i <= n; i++) { // 출발 도시 i
        for (int j = 1; j <= n; j++) { // 도착 도시 j
          // 만약 도시 i에서 도시 j로 가는 경로가 없거나, 비용이 무한대일 경우
          if (d[i][j] == 0 || d[i][j] == INF) {
            System.out.println("0"); // 경로가 없음을 출력
            continue; // 다음 도시 쌍으로 넘어감
          }

          List<Integer> path = new ArrayList<>(); // 경로를 저장할 리스트
          int cur = i; // 현재 도시를 출발 도시 i로 초기화

          // 도시 st가 목적지 도시 j가 될 때까지 경로를 추적
          while (cur != j) {
            path.add(cur); // 현재 도시를 경로에 추가
            cur = nxt[cur][j]; // 다음 거쳐가는 도시로 이동
          }
          path.add(j); // 마지막 목적지 도시 j를 경로에 추가

          // 경로의 도시 개수와 경로를 출력
          System.out.print(path.size() + " "); // 1. 경로에 포함된 도시의 개수 출력
          for (int x : path) { // 2. 경로에 포함된 도시들을 출력
            System.out.print(x + " ");
          }
          System.out.println(); // 3. 다음 줄로 이동
        }
      }

    } catch (IOException ignore) {}
  }
}
