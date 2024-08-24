package gyeol.week03;

import java.util.ArrayDeque;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int truckWeightLen = truck_weights.length();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        // 1. truck_weights를 큐에 넣는다.
        for (int t : truck_weights) {
            q.addLast(t);
        }

        int time = 0; // 경과 시간
        int busCount = 0; // 다리위에 있는 트럭 갯수
        int truckWeight = 0; //다리위에 있는 트럭 무게

        // 2. 2번 while문 조건은 무게 합이 weight가 되거나 버스 갯수가 bridge_length 될 때까지 poll
        while(!q.isEmpty() || truckWeight < weight || busCount < bridge_length) {
            // truckWeight += q.poll();
            // busCount++;
            // time++;
        }

        int answer = 0;
        return answer;
    }
}
// O(N)
// 어려운 점: 1. 트럭무게와 버스갯수를 어떻게 다시 줄여야 할까?
//           2. 대기에서 다리로 간 트럭의 구분과 다리에 있는 트럭과 다리를 지난 트럭의 구분
//              이렇게 총 3개를 어떻게 구분해야할까?
//              큐를 두개 만들어야 하나..

