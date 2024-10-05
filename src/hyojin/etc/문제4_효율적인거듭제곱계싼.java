package hyojin.etc;

public class 문제4_효율적인거듭제곱계싼 {
    public static void main(String[] args) {
        long result = solution(2, 10);
        System.out.println("result = " + result);
    }

    private static long solution(int x, int n) {
        if (n == 0) {
            return 1;
        }

        long half = solution(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        }  else {
            return x * half * half;
        }
    }
}
