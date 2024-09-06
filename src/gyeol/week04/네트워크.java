package gyeol.week04;

import java.util.ArrayList;

public class 네트워크 {
    private static boolean[] visited;
    // 인접리스트
    private static ArrayList<Integer>[] computer;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        computer = new ArrayList[n];

        // 1. 인접리스트 초기화
        for (int i = 0; i < n; i++) {
            computer[i] = new ArrayList<>();
        }

        // 2. 인접리스트 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 2-1. i와 j가 같지 않거나 1인 경우에만 추가
                if ((i != j) & (computers[i][j] == 1)) {
                    computer[i].add(j);
                }
            }
        }


        // 3. dfs탐색
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                // 재귀에서 빠져나오면 카운트+1
                answer++;
            }
        }

        return answer;
    }

    // dfs탐색 순서
    // 1. 방문 표시
    // 2. arrayList배열 다 꺼내기
    // 3. 꺼낸 수로 재귀
    public void dfs(int k) {
        visited[k] = true;
        for (int m : computer[k]) {
            if (!visited[m]) {
                dfs(m);
            }
        }
    }
}