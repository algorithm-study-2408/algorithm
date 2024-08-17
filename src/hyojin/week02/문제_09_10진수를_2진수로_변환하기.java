package hyojin.week02;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class 문제_09_10진수를_2진수로_변환하기 {
    public static void main(String[] args) {
        // 10 -> 1010

        Scanner sc = new Scanner(System.in);
        int decimal = sc.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (true) {
            if (decimal == 0) {
                break;
            }
            if (decimal == 1) {
                stack.push(decimal);
                break;
            }
            int i = decimal % 2;
            decimal /= 2;
            stack.push(i);
        }

        int size = stack.size();
        String answer = "";
        for (int i = 0; i < size; i++) {
            answer += stack.pop();
        }

        System.out.println("answer = " + answer);
    }
}
