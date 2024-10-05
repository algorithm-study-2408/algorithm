package hyojin.week05;

import java.util.ArrayList;

public class 순위 {

    private static ArrayList<Integer>[] winList; // 이긴 선수 기록
    private static ArrayList<Integer>[] loseList; // 진 선수 기록
    private static int[] winCount; // 각 선수가 이긴 선수 수
    private static int[] loseCount; // 각 선수가 진 선수 수

    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        // 인접리스트 초기화
        winList = new ArrayList[n + 1];
        loseList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            winList[i] = new ArrayList<>();
            loseList[i] = new ArrayList<>();
        }

        // 그래프 생성
        for (int[] result : results) {
            winList[result[0]].add(result[1]);  // 이긴 사람
            loseList[result[1]].add(result[0]); // 진 사람
        }

        // 승리 횟수와 패배 횟수를 기록할 배열
        winCount = new int[n + 1];
        loseCount = new int[n + 1];

        // 깊이 우선 탐색 (이긴사람)
        for (int i = 0; i < n; i++) {
            visited = new boolean[n + 1]; // 방문기록 초기화
            counting(i, winList, winCount);
        }

        // 깊이 우선 탐색 (진사람)
        for (int i = 0; i < n; i++) {
            visited = new boolean[n + 1]; // 방문기록 초기화
            counting(i, loseList, loseCount);
        }

        // 정확한 순위를 알 수 있는 선수 ( winCount + loseCount = n-1)
        for (int i = 1; i <= n; i++) {
            if (winCount[i] + loseCount[i] == n - 1) {
                answer.add(i);
            }
        }
        System.out.println("answer = " + answer);
    }

    private static void counting(int now, ArrayList<Integer>[] list, int[] count) {
        visited[now] = true;
        for (int next : list[now]) {
            if (!visited[next]) {
                count[next]++;
            }
        }
    }
}
