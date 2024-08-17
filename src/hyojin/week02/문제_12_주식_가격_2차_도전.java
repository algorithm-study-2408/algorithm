package hyojin.week02;

import java.io.IOException;
import java.util.ArrayDeque;

public class 문제_12_주식_가격_2차_도전 {
    public static void main(String[] args) throws IOException {

        // 흐르는 시간 초 = 인덱스 순서와 비슷하지 않을까 고려

        // 인덱스 : 0 1 2 3 4
        // 주가   : 1 2 3 2 3

        int[] prices = {1, 2, 3, 2, 3};
        int n = prices.length;
        int[] answer = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 첫 번째 값은 push
            if (i == 0) {
                stack.push(i);
            } else {
                // 두 번째 값부터 현재 값과 이전 값을 비교
                int current = prices[i];
                int prev = prices[stack.peek()];
                // 이전 값보다 작아지면 pop
                if (current < prev) {
                    int pop = stack.pop();
                    answer[pop] = i - pop;
                }
                // 현재 값은 stack에 저장
                stack.push(i);
            }
        }

        // stack에 남아있는 주식들
        while (!stack.isEmpty()) {
            int j = stack.pop();
            // 마지막 시간에서 주식의 인덱스값을 뺀다.
            answer[j] = (n - 1) - j;
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }

    }

}
