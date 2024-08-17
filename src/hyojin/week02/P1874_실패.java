package hyojin.week02;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1874_실패 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int current = 1;
        for (int i = 0; i < n; i++) {
            int number = target[i];
            // push
            if (current < number) {
                // FIXME
                for (int j = 0; j < number; j++) {
                    stack.push(i);
                    current = number;
                    System.out.println("+");
                }
            }
            // pop
            else if (current < number && !(current <= 0)) {
                while (true) {
                    int peek = stack.peek(); // 4, 3, ...
                    if (peek <= number) {
                        int pop = stack.pop();
                        System.out.println("-");
                    } else {
                        break;
                    }
                }
            }
        }

    }
}
