package gyeol.dp;

public class 땅따먹기 {
    int solution(int[][] land) {
        int len = land.length;
        int[][] dp = new int[len][4]; // 최대값 저장 배열

        // 1. 첫 번째 배열 복사
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        // 2. 최대 값을 저장하며 내려간다.
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0; // 한 행 이전의 것 중 // 열이 다른 것 중 // 가장 큰 수
                // 2-1. max를 구한다.
                for (int k = 0; k < 4; k++) {
                    if (j == k){
                        continue;
                    }
                    max = Math.max(max, dp[i - 1][k]);
                }
                dp[i][j] = max + land[i][j];
            }
        }

        // 3. 최대 값
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[len - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        땅따먹기 a = new 땅따먹기();
        System.out.println(a.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}

