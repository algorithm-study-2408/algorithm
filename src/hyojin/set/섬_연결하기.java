package hyojin.set;

import java.util.Arrays;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861?language=java
 * 파인드-유니온을 사용하여 문제풀이
 */
public class 섬_연결하기 {

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int result = solution(n, costs);
        System.out.println("result = " + result);
    }

    private static int solution(int n, int[][] costs) {
        // 오름차순 정렬 (왜 회색이지?)
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgesUsed = 0;

        // 섬을 연결한다.
        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int bridgeCost = cost[2];

            // 사이클 확인
            if (find(parent, island1) != find(parent, island2)) {
                // 두 섬을 연결
                union(parent, island1, island2);
                totalCost += bridgeCost;
                edgesUsed++;

                // 모든 섬이 연결되면 종료
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalCost;
    }

    /*
    * find 경로압축 알고리즘
    * 1. parent[7] = parent[6] = parent[2] = parent[1]
    * 2. 경로 압축을 적용하면서 역순으로 각 노드를 루트에 직접 연결
    * 3. parent[2] = 1
    *    parent[6] = 1
    *    parent[7] = 1
    * */

    private static int find(int[] parent, int island) {
        if (parent[island] == island) {
            return island;
        }
        return parent[island] = find(parent, parent[island]);
    }

    private static void union(int[] parent, int island1, int island2) {
        int root1 = find(parent, island1);
        int root2 = find(parent, island2);
        parent[root1] = root2;
    }

}
