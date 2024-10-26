package gyeol.tree;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */
public class 예상대진표 {
    public int solution(int n, int a, int b) {
        int count = 1;
        // 1. a와 b가 1 차이가 나면서 낮은 수가 홀수 높은 수가 짝수일 때까지 반복
        while(!(Math.abs(a - b) == 1 && (Math.max(a, b) % 2 == 0) && (Math.min(a, b) % 2 == 1))) {
            if (a % 2 == 0) {
                a = a/2;
            } else {
                a = a/2 + 1;
            }
            if (b % 2 == 0) {
                b = b/2;
            } else {
                b = b/2 + 1;
            }
            count++;
        }

        System.out.println(count);

        return count;
    }
}
