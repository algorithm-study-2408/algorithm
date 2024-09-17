package jaehoon.week04;

public class Lv03_순위_플로이드풀이 {
  public int solution(int n, int[][] results) {
    int answer = 0;

    // chk[i][j]는 i가 j를 이긴 기록을 나타냄
    boolean[][] d = new boolean[n + 1][n + 1];

    // 주어진 결과를 바탕으로 직접 승패 기록을 채움
    for (int[] result : results) {
      d[result[0]][result[1]] = true;
    }

    // 플로이드-와샬 알고리즘을 이용해 간접 승패 정보를 채움
    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          // i != j 조건을 루프 안에서 제외, i가 k를 이기고 k가 j를 이기면, i는 j를 이김
          if (d[i][k] && d[k][j]) {
            d[i][j] = true;
          }
        }
      }
    }

    // 각 선수가 다른 선수들과의 승패를 비교하여 순위를 매길 수 있는지 확인
    for (int i = 1; i <= n; i++) {
      boolean pass = true; // 순위를 매길수 있는지 여부를 판단하는 flag
      for (int j = 1; j <= n; j++) {
        // 자기자신이 아닐때, 서로의 승패가 확실하지 않으면 순위를 매길 수 없음
        // !(d[i][j] || d[j][i]) 는 두 선수 사이에 승패 기록이 없음을 의미
        if (i != j && !(d[i][j] || d[j][i])) {
          pass = false;
          break;
        }
      }
      // 모든 승패가 확실하면 순위를 매길 수 있음
      if (pass) answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
    Lv03_순위_플로이드풀이 main = new Lv03_순위_플로이드풀이();
    // 입력값 예시
    // 5
    // {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}
    int n = 5;
    int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

    // 출력값 예시
    // 2
    System.out.println("result = " + main.solution(n, results));
  }

}
