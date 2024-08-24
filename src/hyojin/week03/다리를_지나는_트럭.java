package hyojin.week03;

import java.util.*;

public class 다리를_지나는_트럭 {
    public static void main(String[] args) {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        // 큐 생성
        Queue<Integer> bridge = new LinkedList<>();
        int currentWeight = 0;
        int timer = 0;
        int index = 0; // 현재 트럭의 인덱스

        // 다리 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (index < truck_weights.length) {
            // 현재 다리 위에서 트럭이 완료되었는지 확인하고, 완료된 트럭의 무게를 업데이트
            currentWeight -= bridge.poll();

            // 새로운 트럭을 다리에 올릴 수 있는지 확인
            if (currentWeight + truck_weights[index] <= weight) {
                bridge.add(truck_weights[index]);
                currentWeight += truck_weights[index];
                index++;
            } else {
                bridge.add(0); // 다리 위에서 아무 트럭도 이동할 수 없는 경우 0을 추가
            }
            timer++;
        }

        // 마지막 트럭이 다리에서 완전히 지나가기 위해 다리 길이만큼 추가 시간을 더해줍니다.
        System.out.println(timer + bridge_length);

    }
}
