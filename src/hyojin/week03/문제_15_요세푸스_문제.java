package hyojin.week03;

import java.util.ArrayDeque;

public class 문제_15_요세푸스_문제 {
    public static void main(String[] args) {

        int N = 5;
        int K = 2;
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int j = 1; j <= N; j++) {
            ad.add(j);
        }

        while (!(ad.size() == 1)) {
            for (int j = 0; j < K - 1; j++) {
                int n = ad.pollFirst();
                ad.addLast(n);
            }
            ad.pollFirst();
        }
        Integer integer = ad.pollFirst();
        System.out.println("integer = " + integer);
    }
}
