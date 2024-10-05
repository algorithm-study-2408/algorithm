package hyojin.etc;

import java.io.*;
import java.util.*;

public class 문제2_이진트리의최대깊이찾기 {
    // 인접 리스트를 이용한 트리 구조 저장
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static int maxDepth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] input = line.split(" ");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);

            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }

        // 루트 노드부터 DFS 탐색 시작 (1번 노드가 루트라고 가정)
        dfs(1, 1);

        // 최대 깊이 출력
        System.out.println(maxDepth);
    }

    // 깊이 우선 탐색 (DFS)를 사용하여 최대 깊이 계산
    public static void dfs(int node, int depth) {
        // 현재 깊이를 최대 깊이와 비교하여 갱신
        maxDepth = Math.max(maxDepth, depth);

        // 자식 노드가 있으면 자식들로 DFS 진행
        if (tree.containsKey(node)) {
            for (int child : tree.get(node)) {
                dfs(child, depth + 1);
            }
        }
    }
}
