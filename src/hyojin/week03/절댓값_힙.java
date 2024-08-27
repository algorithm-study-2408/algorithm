package hyojin.week03;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 절댓값_힙 {
    public static void main(String[] args) {
        /**
         * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
         *
         * 배열에 정수 x (x ≠ 0)를 넣는다.
         * 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
         * 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
         * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
         *
         * 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
         * x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
         * 입력되는 정수는 -231보다 크고, 231보다 작다.
         */

        // 입력 받을 큐
        PriorityQueue<Integer> absHeap = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            } else {
                return first_abs - second_abs;
            }
        });

        // 테스트 데이터 배열
        int[] p = {18, 1, -1, 0, 0, 0, 1, 1, -1, -1, 2, -2, 0, 0, 0, 0, 0, 0, 0};
        for (int value : p) {
            if (value != 0) {
                absHeap.add(value);
            } else {
                // 절댓값이 가장 작은 값을 출력하고 제거
                if (!absHeap.isEmpty()) {
                    System.out.println(absHeap.poll());
                }
            }
        }


    }
}
