package jaehoon.week09;

import java.util.Arrays;
import java.util.Comparator;

public class Lv03_섬연결하기 {

  static int[] parent;

  static int find(int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  static void union(int x, int y) {
    int root1 = find(x);
    int root2 = find(y);
    parent[root2] = root1;
  }

  public static int solution(int n, int[][] costs) {
    // 1. 최소비용부터 연결하기 위해 비용을 기준으로 간선들을 오름차순 정렬
    Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

    // 2. 유니온 파인드 초기화 (초기에는 각 노드가 자기 자신을 부모로 설정)
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    int minCost = 0;  // 최소 비용을 저장할 변수
    int connectedCount = 0;  // 같은 집합으로 연결된 숫자

    // 3. costs를 순회하면서 각 노드를 연결시킴
    for (int[] input : costs) {
      int islandA = input[0];
      int islandB = input[1];
      int cost = input[2];

      // 3-1. 두 섬이 같은 집합에 속하지 않는 경우에만 간선을 추가 (find시 경로압축을 적용)
      if (find(islandA) != find(islandB)) {

        // 두 노드가 합쳐지면 두 노드의 parent 배열은 같은 대표원소를 가짐 (같은 집합으로 연결되었다는 의미)
        union(islandA, islandB);
        minCost += cost;
        connectedCount++;

        // 모든 섬이 연결된 경우 반복문 종료
        if (connectedCount == n - 1) {
          break;
        }
      }
    }

    return minCost;
  }

  public static void main(String[] args) {
    int n = 4;
    int[][] costs = {
        {0, 1, 1},
        {0, 2, 2},
        {1, 2, 5},
        {1, 3, 1},
        {2, 3, 8}
    };
    int result = solution(n, costs);
    System.out.println("result = " + result);
  }
}
