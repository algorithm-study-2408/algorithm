package jaehoon.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {

  // 무한대 숫자
  static final int INF = 0x3f3f3f3f;

  // 최단거리를 저장할 배열
  static int[][] d = new int[105][105];

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

      // 버스 정보 입력받기
      for (int i = 0; i < m; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 시작 도시
        int b = Integer.parseInt(st.nextToken()); // 도착 도시
        int c = Integer.parseInt(st.nextToken()); // 비용
        d[a][b] = Math.min(d[a][b], c); // 같은 경로의 버스가 여러 개일 수 있음 (최소값 저장)
      }

      // 자기 자신으로 가는 비용은 0
      for (int i = 1; i <= n; i++) {
        d[i][i] = 0;
      }

      // 플로이드-와샬 알고리즘
      // 바로 s -> t로 가는 경로보다 k를 거쳐가는 경로가 빠른지 확인 (중간에 거쳐가게끔 할 원소를 3중 for문에 가장 바깥에 두어야 함)
      for (int k = 1; k <= n; k++) { // 경유지
        for (int s = 1; s <= n; s++) { // 출발지
          for (int t = 1; t <= n; t++) { // 도착지
            if (d[s][t] > d[s][k] + d[k][t]) {
              d[s][t] = d[s][k] + d[k][t]; // 최단거리 갱신
            }
          }
        }
      }

      // 출력값 예시 :
      /*
      0 2 3 1 4
      12 0 15 2 5
      8 5 0 1 1
      10 7 13 0 3
      7 4 10 6 0
      */
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


    } catch (IOException ignore) {}
  }

}
