package hyojin.week04;

import java.awt.image.VolatileImage;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class 문제_35_너비_우선_탐색_순회 {

    private static ArrayList<Integer>[] adjList;

    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}};
        int start = 1;
        int n = 9;

        // 인접 리스트 초기화
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 그래프를 인접리스트로 변환
        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        // BFS를 순회한 결과를 반환
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        bfs(start);

        int[] ints = answer.stream().mapToInt(Integer::intValue).toArray();
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    private static void bfs(int start) {
        // 탐색시 맨 처음 방문할 노드를 add하고 방문 처리
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        // 큐가 비어 있지 않은 동안 반복
        while (!queue.isEmpty()) {
            int now = queue.poll();
            answer.add(now);
            for (int next: adjList[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }

    }
}
