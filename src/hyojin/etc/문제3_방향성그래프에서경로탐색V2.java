package hyojin.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 문제3_방향성그래프에서경로탐색V2 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static boolean pathExists = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        // 방문 배열 초기화
        visited = new boolean[n + 1];

        dfs(startNode, endNode);

        // 결과 출력
        if (pathExists) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void dfs(int current, int target) {
        // 현재 노드가 목표 노드에 도달한 경우
        if (current == target) {
            pathExists = true;
            return;
        }

        // 현재 노드 방문 처리
        visited[current] = true;

        // 인접한 노드 탐색
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor, target);
                if (pathExists) {
                    return; // 경로가 발견되면 더 이상 탐색할 필요 없음
                }
            }
        }

        // 방문 상태 초기화 (다른 경로 탐색을 위해)
        visited[current] = false;
    }
}
