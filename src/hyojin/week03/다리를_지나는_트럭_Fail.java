package hyojin.week03;

import java.util.ArrayDeque;

public class 다리를_지나는_트럭_Fail {
    public static void main(String[] args) {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        // 큐 생성
        ArrayDeque<Integer> stanby_queue = new ArrayDeque<>();
        for (int i = 0; i < truck_weights.length; i++) {
            stanby_queue.addLast(truck_weights[i]);
        }

        int timer = 0;
        while (!stanby_queue.isEmpty()) {

            // 1. 무게 비교 (다리에는 bridge_length 만큼만 올라갈 수 있음)
            if (stanby_queue.peek() <= weight) {
                int sum = stanby_queue.pollFirst();

                // 지나간 트럭 변수
                ArrayDeque<Integer> crossedTrucks = new ArrayDeque<>();
                crossedTrucks.push(1);

                for (int i = 0; i < bridge_length; i++) {
                    // 2. 무게를 초과할 경우 하나만 지나간다.
                    if (!stanby_queue.isEmpty() && sum + stanby_queue.peek() <= weight) {
                        sum += stanby_queue.pollFirst();
                        crossedTrucks.push(i);
                    }
                    timer++;
                }
                // 지나간 트럭 시간 계산
                if (crossedTrucks.size() > 1) {
                    for (Integer crossedTruck : crossedTrucks) {
                        timer++;
                    }
                }

            }
        }

        System.out.println(timer);

    }
}
