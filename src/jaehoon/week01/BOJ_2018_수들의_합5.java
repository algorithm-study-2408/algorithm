package jaehoon.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018_수들의_합5 {

  // 시간복잡도 O(N) - 투포인터 활용
  public int solution1(int n) {
    int answer = 0;
    int sum = 0;
    int lt = 1; // 시작점을 나타내는 포인터 (left)

    // rt 포인터를 1부터 n까지 이동하며 연속된 자연수의 합을 계산
    for (int rt = 1; rt <= n; rt++) {
      sum += rt; // 현재 rt 값을 sum에 더함

      // sum이 n과 같으면 경우의 수를 증가
      if (sum == n) {
        answer++;
      }

      // sum이 n보다 크거나 같을 때, lt 포인터를 이동시켜 sum을 줄임
      while (sum >= n) {
        sum -= lt++; // lt 값을 sum에서 빼고, lt를 증가시킴

        // sum이 n과 같으면 경우의 수를 증가
        if (sum == n) {
          answer++;
        }
      }
    }
    return answer;
  }

  // 시간복잡도 O(N^2) - 이중반복문으로 풀면 시간초과
  public int solution2(int n) {
    int answer = 0;
    for (int start = 1; start <= n; start++) {
      int sum = 0;
      for (int end = start; end <= n; end++) {
        sum += end;
        // 수들의 합이 N과 같으면 경우의 수 +1 증가
        if (sum == n) {
          answer++;
          break;
        }
        // 수들의 합이 N보다 크면 안쪽 for문 종료
        else if (sum > n) {
          break;
        }
      }

    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    BOJ_2018_수들의_합5 main = new BOJ_2018_수들의_합5();
    // 입력예시 :
    // 15
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.valueOf(br.readLine());
    System.out.println(main.solution1(n)); // 4
    System.out.println(main.solution2(n)); // 4
  }
}
