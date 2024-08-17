package hyojin.week02;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1874_GPT {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] target = new int[n];

        // 목표 수열 읽기
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int current = 1; // 현재 스택에 넣을 수

        for (int i = 0; i < n; i++) {
            int number = target[i];

            // 스택에 number까지의 모든 수를 push
            while (current <= number) {
                stack.push(current++);
                sb.append("+").append("\n");
            }

            // 스택의 top이 목표 수와 일치하면 pop
            if (stack.peek() == number) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                // 목표 수가 스택의 top과 일치하지 않으면 불가능
                System.out.println("NO");
                return;
            }
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}
