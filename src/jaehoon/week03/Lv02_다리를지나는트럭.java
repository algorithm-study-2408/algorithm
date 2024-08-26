package jaehoon.week03;

import java.util.ArrayDeque;

public class Lv02_다리를지나는트럭 {

  class Truck {
    private final int weight;
    private int timeOnBridge; // 트럭이 다리 위에 머무른 시간

    public Truck(int weight) {
      this.weight = weight;
      this.timeOnBridge = 0;
    }

    public void move() {
      this.timeOnBridge++;
    }

    public boolean hasCrossed(int bridgeLength) {
      return this.timeOnBridge >= bridgeLength;
    }

    public int getWeight() {
      return weight;
    }
  }

  public int solution1(int bridge_length, int weight, int[] truck_weights) {
    // 다리에 있는 트럭을 순서대로 저장할 Deque 자료구조
    ArrayDeque<Truck> bridge = new ArrayDeque<>();

    int timer = 0; // 다리를 지나는 시간
    int totalWeight = 0; // 다리 위의 트럭들의 총 무게
    int index = 0; // 대기 중인 트럭의 인덱스

    //1. 트럭들이 모두 다리에 건널때까지 반복
    while (index < truck_weights.length || !bridge.isEmpty()) {
      timer++; // 시간 증가

      // 1-1. 다리 위의 모든 트럭을 한 칸씩 전진
      for (Truck truck : bridge) {
        truck.move();
      }

      // 1-2. 다리에 처음 들어간 트럭이 다리를 다 건넜으면 큐에서 제거
      if (!bridge.isEmpty() && bridge.peek().hasCrossed(bridge_length)) {
        Truck crossedTruck = bridge.pollFirst(); // 다리에서 트럭 제거
        totalWeight -= crossedTruck.getWeight(); // 다리의 총 무게에서 해당 트럭의 무게를 차감
      }

      // 1-3. 대기 중인 트럭이 다리에 올라갈 수 있으면 트럭을 다리에 추가
      if (index < truck_weights.length && bridge.size() < bridge_length && (totalWeight + truck_weights[index]) <= weight) {
        Truck newTruck = new Truck(truck_weights[index]);
        bridge.addLast(newTruck);
        totalWeight += newTruck.getWeight();
        index++; // 다음 트럭으로 이동
      }
    }
    return timer;
  }

  public int solution2(int bridge_length, int weight, int[] truck_weights) {
    ArrayDeque<Integer> bridge = new ArrayDeque<>(); // 다리에 있는 트럭을 순서대로 저장할 Deque 자료구조 사용
    int timer = 0; // 다리를 지나는 시간
    int currentWeight = 0; // 다리 위의 트럭들의 총 무게
    int index = 0; // 대기 중인 트럭의 인덱스

    // 1. 다리에 올라갈 수 있는 트럭의 수 만큼 0으로 초기화 (다리에 올라갈수 있는 트럭의 수 제한)
    for (int i = 0; i < bridge_length; i++) {
      bridge.addLast(0);
    }

    // 2. 트럭들이 모두 다리에 올라갈때까지 반복
    while (index < truck_weights.length) {
      // 2-1. 현재 다리에 올라간 트럭을 순서대로 빼주어 도착한 트럭의 무게를 업데이트 "빈칸(0)은 무시됨"
      currentWeight -= bridge.pollFirst();

      // 2-2. 새로운 트럭을 다리에 올릴 수 있는지 확인 (다리위의 트럭의 무게에 대기중인 트럭의 무게를 더해서 제한 무게확인)
      if (currentWeight + truck_weights[index] <= weight) {
        bridge.addLast(truck_weights[index]);
        currentWeight += truck_weights[index];
        index++; // 다음 트럭으로 이동
      }
      // 2-3. 새로운 트럭을 다리에 올릴 수 없는 경우 빈칸(0)을 올림
      else {
        bridge.addLast(0);
      }
      timer++; // 시간증가
    }
    // 3. (마지막 트럭이 올라간시간 + 다리를 건널때까지 남은시간) 반환
    return timer + bridge_length;
  }

  public static void main(String[] args) {
    Lv02_다리를지나는트럭 main = new Lv02_다리를지나는트럭();

    // 입력값 예시
    int bridge_length = 2;
    int weight = 10;
    int[] truck_weights = {7, 4, 5, 6};
    System.out.println("result1 = " + main.solution1(bridge_length, weight, truck_weights));
    System.out.println("result2 = " + main.solution2(bridge_length, weight, truck_weights));

  }
}
