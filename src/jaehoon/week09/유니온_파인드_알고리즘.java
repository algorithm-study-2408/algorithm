package jaehoon.week09;

import java.util.ArrayList;
import java.util.Arrays;

public class 유니온_파인드_알고리즘 {

  static int[] parent;

  private static int find(int x) {
    // 만약 x의 부모노드가 자기자신이라면 루트노드
    if (parent[x] == x) {
      return x;
    }

    // x의 부모를 찾아서 parent[x]에 저장 (경로 압축)
    return parent[x] = find(parent[x]);
  }

  private static void union(int x, int y) {
    int root1 = find(x);
    int root2 = find(y);
    // root1을 기준으로 root2를 합침
    parent[root2] = root1;
  }

  private static Boolean[] solution(int k, int[][] operations) {
    parent = new int[k];

    // 1. 처음에는 각 노드가 자기 자신을 부모로 가지도록 초기화
    for (int i = 0; i < k; i++) {
      parent[i] = i;
    }

    // 2. 연산 수행
    ArrayList<Boolean> answer = new ArrayList<>(); // 연산의 결과를 저장할 리스트
    for (int[] op : operations) {
      // 0연산 (union)
      if (op[0] == 0) {
        union(op[1], op[2]);
      }
      // 1연산 (같은 집합에 속해있는지 확인)
      else {
        answer.add(find(op[1]) == find(op[2]));
      }
    }

    // 리스트를 배열로 변환
    // 인자로 들어가는 배열의 크기가 ArrayList의 크기보다 작다면, 새로운 배열을 생성하여 복사
    return answer.toArray(new Boolean[0]);
  }

  public static void main(String[] args) {
    // 입력값 예시:

    // 노드의 개수
    // k = 4
    int k = 4;

    // 배열의 첫번째가 0이면 union, 배열의 첫번째가 1이면 같은 집합에 속해있는지 확인
    // operations = {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}}
    int[][] operations = {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}};

    Boolean[] result = solution(k, operations);
    System.out.println("result = " + Arrays.toString(result));

  }
}
