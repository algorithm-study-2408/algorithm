package jaehoon.week08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 트리순회_인접리스트 {

  // 인접 리스트로 트리 구조를 표현
  private static Map<Integer, List<Integer>> tree = new HashMap<>();

  public static void main(String[] args) {
    // 예시 트리: 1 - 2 - 3 - 4 - 5 - 6 - 7 (배열로 된 트리)
    int[] input = {1, 2, 3, 4, 5, 6, 7};
    buildTree(input);
    List<String> result = solution();
    System.out.println("result = " + result);
  }

  static List<String> solution() {
    // 전위, 중위, 후위 순회를 수행하여 출력
    List<String> list = new ArrayList<>();
    list.add(preorder(1).trim());
    list.add(inorder(1).trim());
    list.add(postorder(1).trim());
    return list;
  }

  // 트리 구성 함수 (인접 리스트로 트리를 표현)
  private static void buildTree(int[] nodes) {
    for (int i = 0; i < nodes.length; i++) {
      tree.putIfAbsent(nodes[i], new ArrayList<>());

      // 왼쪽 자식
      int leftIdx = 2 * i + 1;
      if (leftIdx < nodes.length) {
        tree.get(nodes[i]).add(nodes[leftIdx]);
      }

      // 오른쪽 자식
      int rightIdx = 2 * i + 2;
      if (rightIdx < nodes.length) {
        tree.get(nodes[i]).add(nodes[rightIdx]);
      }
    }
  }

  // 전위 순회: 루트 -> 왼쪽 -> 오른쪽
  private static String preorder(int node) {
    if (!tree.containsKey(node)) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    sb.append(node).append(" ");

    List<Integer> children = tree.get(node);
    if (!children.isEmpty()) {
      sb.append(preorder(children.get(0))); // 왼쪽 자식
      if (children.size() > 1) {
        sb.append(preorder(children.get(1))); // 오른쪽 자식
      }
    }

    return sb.toString();
  }

  // 중위 순회: 왼쪽 -> 루트 -> 오른쪽
  private static String inorder(int node) {
    if (!tree.containsKey(node)) {
      return "";
    }

    StringBuilder sb = new StringBuilder();

    List<Integer> children = tree.get(node);
    if (!children.isEmpty()) {
      sb.append(inorder(children.get(0))); // 왼쪽 자식
    }

    sb.append(node).append(" "); // 루트 노드

    if (children.size() > 1) {
      sb.append(inorder(children.get(1))); // 오른쪽 자식
    }

    return sb.toString();
  }

  // 후위 순회: 왼쪽 -> 오른쪽 -> 루트
  private static String postorder(int node) {
    if (!tree.containsKey(node)) {
      return "";
    }

    StringBuilder sb = new StringBuilder();

    List<Integer> children = tree.get(node);
    if (!children.isEmpty()) {
      sb.append(postorder(children.get(0))); // 왼쪽 자식
      if (children.size() > 1) {
        sb.append(postorder(children.get(1))); // 오른쪽 자식
      }
    }

    sb.append(node).append(" "); // 루트 노드

    return sb.toString();
  }
}