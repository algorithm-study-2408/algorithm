package hyojin.etc;

public class 문제5_최대공약수계산 {
    public static void main(String[] args) {
        int result = solution(48, 18);
    }

    private static int solution(int a, int b) {
        if (b == 0) {
            return a;
        }
        return solution(b, a % b);
    }
}
