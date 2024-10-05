package hyojin.etc;

public class 문제1_피보나치 {
    public static void main(String[] args) {
        재귀적풀이(5);
        메모이제이션(5);
        반복문(5);
    }

    private static int 반복문(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private static int[] memo = new int[41]; // 0 <= n <= 40
    private static int 메모이제이션(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = 메모이제이션(n - 1) + 메모이제이션(n - 2);
        return memo[n];
    }

    private static int 재귀적풀이(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return 재귀적풀이(n - 1) + 재귀적풀이(n - 2);
    }

}
