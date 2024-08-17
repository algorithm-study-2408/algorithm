package hyojin.week02;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 문제_13_크레인_인형_뽑기_게임 {
    public static void main(String[] args) {
        // 입출력 입력, board, moves 변수 선언
        int[][] boards = {{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1,}};
        int[] moves = {1,5,3,5,1,2,1,4};

        // board를 각 열(column) 별로 스택에 저장
        ArrayDeque<Integer>[] stacks = new ArrayDeque[boards.length];
        for (int i = 0; i < boards.length; i++) {
            stacks[i] = new ArrayDeque<>();
            // 헷갈렸던 부분.. 반대로 넣어야 한다.
            for (int j = boards.length - 1; j >= 0; j--) {
                if (boards[j][i] != 0) {
                    stacks[i].push(boards[j][i]);
                }
            }
        }

        // 바구니 역할을 할 스택 생성
        // 바구니에는 모든 인형이 들어갈 수 있다고 하니 배열보단 stack이 효율적이다.
        ArrayDeque<Integer> basket = new ArrayDeque<>();
        int removedDolls = 0; // 제거된 인형의 개수

        // moves 순서대로 바구니에 담음
        for (int move : moves) {
            int column = move - 1; // 1부터 시작하는 moves를 0부터 시작하는 인덱스로 변환

            // 격자칸이 비어있는지 확인
            if (!stacks[column].isEmpty()) {
                int doll = stacks[column].pop(); // 인형을 꺼내 바구니에 넣음

                if (!basket.isEmpty() && basket.peek() == doll) {
                    basket.pop(); // 이전 인형과 같으면 제거
                    removedDolls += 2; // 제거된 인형은 2개
                } else {
                    basket.push(doll); // 바구니에 인형을 추가
                }
            }
        }
        System.out.println("removedDolls = " + removedDolls);

    }
}
