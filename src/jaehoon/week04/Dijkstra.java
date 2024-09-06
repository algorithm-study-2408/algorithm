package jaehoon.week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {

  private static class Node {
    int dest, cost;

    public Node(int dest, int cost) {
      this.dest = dest;
      this.cost = cost;
    }
  }

  public static int[] dijkstra(int[][] graph, int start, int n) {
    // 1. 인접 리스트를 저장할 ArrayList 배열 초기화
    ArrayList<Node>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }
    // 2. graph 정보를 인접리스트로 저장
    for (int[] edge : graph) {
      adj[edge[0]].add(new Node(edge[1], edge[2]));
    }

    // 3. 모든 노드의 거리 값을 무한대로 초기화
    // 4. 시작 노드의 거리 값은 0으로 초기화
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    // 5. 우선순위 큐를 생성하고 시작 노드를 삽입
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    pq.add(new Node(start, 0));

    // 6. 다익스트라 알고리즘 실행
    // 방문 여부를 저장하는 배열, 모든 노드는 아직 방문하지 않음
    boolean[] visited = new boolean[n];
    while (!pq.isEmpty()) {
      // 우선순위 큐에서 현재 가장 거리가 짧은 노드를 가져옴
      Node current = pq.poll();

      // 이미 방문한 노드이면 무시하고 넘어감
      if (visited[current.dest]) continue;
      // 현재 노드를 방문했음을 표시
      visited[current.dest] = true;

      // 현재 노드의 모든 인접 노드(neighbor)에 대해 최단 거리를 갱신
      for (Node neighbor : adj[current.dest]) {
        // 인접 노드까지의 기존 최단 거리보다 현재 노드를 거쳐가는 경로가 더 짧다면 최단 거리 갱신
        if (dist[neighbor.dest] > dist[current.dest] + neighbor.cost) {
          dist[neighbor.dest] = dist[current.dest] + neighbor.cost; // 새로운 최단 거리로 업데이트
          pq.add(new Node(neighbor.dest, dist[neighbor.dest])); // 인접 노드를 우선순위 큐에 추가
        }
      }
    }
    // 각 노드까지의 최단 거리를 저장한 배열을 반환
    return dist;
  }
  // 다익스트라 알고리즘 수행 과정 주석
/*
Initial state:
Node:  A  B  C  D  E
Dist:  0  INF  INF  INF  INF
Prev:  -1  -1  -1  -1  -1

1. A 노드 선택 (현재 최단 거리: 0)
- 인접 노드 B, C, E 업데이트:
After visiting A:
Node:  A  B  C  D  E
Dist:  0  4  4  INF  1
Prev:  -1  0  0  -1  0

2. E 노드 선택 (현재 최단 거리: 1)
- 인접 노드 C 업데이트:
After visiting E:
Node:  A  B  C  D  E
Dist:  0  4  3  INF  1
Prev:  -1  0  4  -1  0

3. C 노드 선택 (현재 최단 거리: 3)
- 인접 노드 B, D 업데이트:
After visiting C:
Node:  A  B  C  D  E
Dist:  0  4  3  11  1
Prev:  -1  0  4  2  0

4. B 노드 선택 (현재 최단 거리: 4)
- 인접 노드 업데이트 없음
After visiting B:
Node:  A  B  C  D  E
Dist:  0  4  3  11  1
Prev:  -1  0  4  2  0

5. D 노드 선택 (현재 최단 거리: 11)
- 인접 노드 B 업데이트:
After visiting D:
Node:  A  B  C  D  E
Dist:  0  4  3  11  1
Prev:  -1  0  4  2  0

최종 상태:
Node:  A  B  C  D  E
Dist:  0  4  3  11  1
Prev:  -1  0  4  2  0
*/

/*
다익스트라 알고리즘에 대한 설명:
1. 다익스트라 알고리즘의 개념:
   다익스트라 알고리즘은 가중치가 있는 그래프에서 특정 시작 노드로부터 다른 모든 노드까지의 최단 경로를 찾는 알고리즘입니다.
   이 알고리즘은 그래프의 모든 간선의 가중치가 양수일 때 유효합니다.

2. 다익스트라 알고리즘의 과정:
   1) 시작 노드의 거리를 0으로 설정하고, 나머지 노드의 거리는 무한대로 설정합니다.
   2) 모든 노드를 미방문 집합에 추가합니다.
   3) 현재 노드에서 인접한 모든 노드의 거리를 계산하여 더 짧은 경로가 발견되면 거리를 업데이트합니다.
   4) 현재 노드를 방문한 것으로 표시하고, 미방문 노드 중 최단 거리를 가진 노드를 선택하여 3) 과정을 반복합니다.
   5) 모든 노드를 방문할 때까지 3)과 4) 과정을 반복합니다.

3. 다익스트라 알고리즘의 시간 복잡도:
   - 인접 리스트를 사용한 구현: O((V+E)log V), 여기서 V는 노드의 개수, E는 간선의 개수입니다.
     (우선순위 큐를 사용하여 최소 거리를 찾고 업데이트하는데 log V 시간이 걸립니다)

4. 다익스트라 알고리즘의 한계:
   - 음수 가중치를 가진 간선이 있는 그래프에서는 동작하지 않습니다. 음수 가중치가 있는 경우 벨만-포드 알고리즘을 사용해야 합니다.

코드 실행 결과:
Node	Distance	Path
0	0		0
1	4		0 1
2	3		0 4 2
3	11	0 4 2 3
4	1		0 4
*/

  public static void main(String[] args) {
    int[][] graph = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
    System.out.println(Arrays.toString(dijkstra(graph, 0, 3)));
    int[][] graph2 = {{0, 1, 1}, {1, 2, 5}, {2, 3, 1}};
    System.out.println(Arrays.toString(dijkstra(graph2, 0, 4)));
  }
}