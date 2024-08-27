package hyojin.week03;

import java.util.ArrayDeque;

public class 문제_17_카드뭉치 {
    public static void main(String[] args) {
//        String[] cards1 = {"i", "drink", "water"};
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        int n = goal.length;
//        String answer = "No";
        ArrayDeque<String> c1 = new ArrayDeque<>();
        for (String c: cards1) {
            c1.addLast(c);
        }
        ArrayDeque<String> c2 = new ArrayDeque<>();
        for (String c : cards2) {
            c2.addLast(c);
        }

        for (int i = 0; i < n; i++) {
            String s = goal[i];
            String s1 = c1.peek();
            String s2 = c2.peek();
            if (!s.equals(s1) && !s.equals(s2)) {
                System.out.println("answer = " + "No");
                return;
            }

            if (s.equals(s1)) {
                c1.pollFirst();
            }
            if (s.equals(s2)) {
                c2.pollFirst();
            }
        }

//        if (c1.isEmpty() && c2.isEmpty()) {
//            System.out.println("answer = " + "Yes");
//        }

        System.out.println("answer = " + "Yes");

    }
}
