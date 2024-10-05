package hyojin.week04;

import java.util.ArrayList;

public class 문제_34_깊이_우선_탐색_순회 {
    // 인접 리스트 저장할 ArrayList 배열
    private static ArrayList<Integer>[] adjList;

    // 방문 여부를 저장할 boolean 배열
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    public static void main(String[] args) {

//        int[][] graph = {{1,2}, {2,3}, {3,4}, {4,5}};
//        int start = 1;
//        int n = 5;

        int[][] graph = {{1,2}, {1,3}, {2,4}, {2,5}, {3,6}, {5,6}};
        int start = 1;
        int n = 6;

        // 인접 리스트 초기화
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 그래프를 인접 리스트로 변환
        for (int[] edge: graph) {
            adjList[edge[0]].add(edge[1]);
        }

        // DFS를 순회한 결과를 반환
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start);

        int[] ints = answer.stream().mapToInt(Integer::intValue).toArray();
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

    static void dfs(int now) {
        visited[now] = true;
        answer.add(now);
        for (int next: adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
