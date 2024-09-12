package jaehoon.week04;

import java.util.Arrays;

/**
 * N개의 마을 중 K시간 이하로 배달이 가능한 마을에서만 주문을 받으려고 함
 * 음식 주문을 받을 수 있는 마을의 개수를 출력
 * 마을의 개수는 50이하 O(N^3) = 300~500 이니까 플로이드 알고리즘 쓸 수 있음
 * 출발마을, 도착마을, 비용 road[0], road[1], road[2]
 */
public class Lv02_배달 {

  static final int INF = 0x3f3f3f3f;

  public static int solution(int N, int[][] road, int K) {
    // 1. 인접행렬 그래프로 변환할 배열
    int[][] dis = new int[N + 1][N + 1];

    // 1-1. 거리 배열을 INF로 초기화
    for (int i = 1; i <= N; i++) {
      Arrays.fill(dis[i], 1, N + 1, INF);
    }

    for (int[] r : road) {
      int row = r[0];
      int col = r[1];
      int price = r[2];
      // 양방향 연결
      if (dis[row][col] > price) {
        dis[row][col] = price;
      }
      if (dis[col][row] > price) {
        dis[col][row] = price;
      }
    }

    // 1-1. 자기 자신으로 가는 비용은 0
    for (int i = 1; i <= N; i++) {
      dis[i][i] = 0;
    }

    // 2. 플로이드-와샬 알고리즘
    // 바로 i -> j로 가는 경로보다 k를 거쳐가는 경로가 빠른지 확인
    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          // 2-1. 거쳐가는 거리가 더 가까우면 최단거리 갱신
          if (dis[i][j] > (dis[i][k] + dis[k][j])) {
            dis[i][j] = dis[i][k] + dis[k][j];
          }
        }
      }
    }

    // 3. 1번 마을에서 K 시간 이하로 배달 가능한 마을 개수 계산
    int count = 0;
    for (int i = 1; i <= N; i++) {
      if (dis[1][i] <= K) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    // 입력값 예시:
    // n : 5
    // road : {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}
    // k : 3
    int n = 5;
    int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
    int k = 3;
    System.out.println("result = " + solution(n, road, k));
  }

}
