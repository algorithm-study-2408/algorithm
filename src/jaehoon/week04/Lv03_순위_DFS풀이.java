package jaehoon.week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv03_순위_DFS풀이 {

  static List<List<Integer>> vic = new ArrayList<>();

  static List<List<Integer>> def = new ArrayList<>();

  static boolean[] visited;

  public static int solution(int n, int[][] results) {
    // 1. 선수별 이긴 선수, 진 선수 기록 저장
    for (int i = 0; i <= n; i++) {
      vic.add(new ArrayList<>());
      def.add(new ArrayList<>());
    }
    for (int[] result : results) {
      vic.get(result[0]).add(result[1]);
      def.get(result[1]).add(result[0]);
    }
    // 2. 방문기록을 저장할 배열 선언
    visited = new boolean[n + 1];

    // 3. i번째 선수의 이긴 선수, 진 선수 탐색
    int count = 0;
    for (int i = 1; i <= n; i++) {
      Arrays.fill(visited, false); // 배열을 매번 초기화
      int w = wDfs(i);

      Arrays.fill(visited, false); // 배열을 매번 초기화
      int l = lDfs(i);

      // 랭킹이 정해진 플레이어 찾기 "랭킹이 정해진 선수 : (이긴선수 + 진선수) == (n - 1)"
      if (w + l == n - 1) {
        count++;
      }
    }

    return count;
  }

  static int wDfs(int cur) {
    int res = 0;
    visited[cur] = true;
    for (int next : vic.get(cur)) {
      if (!visited[next]) {
        res += wDfs(next) + 1;
      }
    }
    return res;
  }

  static int lDfs(int cur) {
    int res = 0;
    visited[cur] = true;
    for (int next : def.get(cur)) {
      if (!visited[next]) {
        res += lDfs(next) + 1;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    // 입력값 예시
    // 5
    // {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}
    int n = 5;
    int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

    // 출력값 예시
    // 2
    System.out.println("result = " + solution(n, results));
  }

}
