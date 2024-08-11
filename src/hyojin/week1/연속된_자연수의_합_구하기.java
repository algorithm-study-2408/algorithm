package hyojin.week1;

import java.util.Scanner;

public class 연속된_자연수의_합_구하기 {
    public static void main(String[] args) {
        /**
         * 투 포인터 이동 원칙
         * sum > N : sum = sum - start_index; start_index++;
         * sum < N : end_index++; sum = sum + end_index;
         * sum == N : end_index++; sum = sum + end_index; count++;
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // N의 값을 제외하므로 초기화를 1로 카운팅함.
        int count = 1;
        int sum = 1;

        // 배열[0]은 숫자 1이라고 가정함.
        int start_index = 1;
        int end_index = 1;

        // 투포인터 공식 적용
        while (end_index != N) {
            if (sum > N) {
                sum -= start_index;
                start_index++;
            } else if (sum < N) {
                end_index++;
                sum += end_index;
            } else {
                end_index++;
                sum += end_index;
                count++;
            }
        }

        System.out.println("count = " + count);
        
    }
}
