package hyojin.set;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861?language=java
 * set을 이용하여 문제 풀이
 */
public class 섬_연결하기2 {

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int result = solution(n, costs);
        System.out.println("result = " + result);
    }

    private static int solution(int n, int[][] costs) {
        // 비용 기준으로 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        // 각 섬을 독립적인 집합으로 초기화
        List<Set<Integer>> islandSets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            islandSets.add(set);
        }

        int totalCost = 0;
        int edgesUsed = 0;

        // 최소 스패닝 트리 구성
        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int bridgeCost = cost[2];

            // 두 섬이 같은 집합에 있는지 확인
            Set<Integer> set1 = null;
            Set<Integer> set2 = null;
            for (Set<Integer> set : islandSets) {
                if (set.contains(island1)) {
                    set1 = set;
                }
                if (set.contains(island2)) {
                    set2 = set;
                }
                // 두 집합을 모두 찾으면 중단
                if (set1 != null && set2 != null) {
                    break;
                }
            }

            // 두 섬이 서로 다른 집합에 속해 있다면 병합
            if (set1 != set2) {
                totalCost += bridgeCost;
                edgesUsed++;

                // 병합하고 하나의 집합으로 통합
                set1.addAll(set2);
                islandSets.remove(set2);

                // 모든 섬이 연결되었으면 종료
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalCost;

    }


}
