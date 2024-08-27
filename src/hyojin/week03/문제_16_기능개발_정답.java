package hyojin.week03;

import java.util.ArrayDeque;

public class 문제_16_기능개발_정답 {
    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55, 80};
        int[] progresses = {95, 90, 99,99,80,99};
//        int[] speeds = {1, 30, 5, 5};
        int[] speeds = {1,1,1,1,1,1};

        ArrayDeque<Integer> answer = new ArrayDeque<>();
        int n = progresses.length;
        int[] daysLeft = new int[n];
        for (int i = 0; i < progresses.length; i++) {
            daysLeft[i] = (int) Math.ceil((100 - progresses[i]) / speeds[i]);
        }

        int count = 0;
        int maxday = daysLeft[0];

        for (int i = 0; i < n; i++) {
            if (daysLeft[i] <= maxday) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                maxday = daysLeft[i];
            }
        }

        answer.add(count);
        int[] ints = answer.stream().mapToInt(Integer::intValue).toArray();
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }

    }
}
