package hyojin.week06;

import java.util.Scanner;

public class week06 {
    public static class DungeonExploration {
        private static int maxDungeonCount = 0;

        public static void main(String[] args) {
            int k = 80;
            int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

            System.out.println(solution(k, dungeons)); // 예상 출력: 3
        }

        public static int solution(int k, int[][] dungeons) {
            boolean[] visited = new boolean[dungeons.length];
            exploreDungeons(k, dungeons, visited, 0);
            return maxDungeonCount;
        }

        private static void exploreDungeons(int currentFatigue, int[][] dungeons, boolean[] visited, int count) {
            // 현재 탐험한 던전 수(count)와 비교해 최대 던전 수 갱신
            maxDungeonCount = Math.max(maxDungeonCount, count);

            // 모든 던전을 순회하면서 탐험 가능 여부 확인
            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && currentFatigue >= dungeons[i][0]) { // 방문하지 않은 던전이고, 최소 피로도 조건을 만족하면
                    visited[i] = true; // 던전을 탐험했다고 표시
                    exploreDungeons(currentFatigue - dungeons[i][1], dungeons, visited, count + 1); // 던전을 탐험한 후 다음 단계로 진행
                    visited[i] = false; // 탐험을 마치고 다음 경우의 수를 위해 원상태로 돌려놓음
                }
            }
        }
    }

    /**
     * 가로, 세로 n인 정사각형
     * n개의 퀸이 서로 공격할 수 없도록 배치
     * n개의 퀸들은 서로 다른 행에 있어야함 -> 같은 행에 Q이 존재한다는 경우의 수 제거
     */
    public static class 문제46_N퀸 {
        private static int N;
        private static int[] board;     // 각 행에 퀸이 놓여진 열을 저장하는 배열
        private static int count = 0;   // 조건을 만족하는 퀸 배치 수

        public static void main(String[] args) {
            // 입출력 및 초기화
            Scanner scanner = new Scanner(System.in);
            N = scanner.nextInt();
            board = new int[N];

            solution(0); // 0번 째 열부터 시작
            System.out.println(count);
        }

        private static void solution(int n) {
            // 모든 퀸을 배치한 경우
            if (n == N) {
                count++;
                return;
            }

            // 각 열에 퀸을 놓는 시도
            for (int col = 0; col < N; col++) {
                if (isSafe(n, col)) {       // 유효성 검사
                    board[n] = col;         // 퀸을 해당 열에 배치
                    solution(n + 1);     // 다음 행으로 이동하여 퀸 배치 (백트래킹)
                }
            }
        }

        // 퀸을 해당 위치에 놓을 수 있는지 확인하는 함수 (row 행, col 열)
        public static boolean isSafe(int row, int col) {
            for (int i = 0; i < row; i++) {
                // 같은 열에 다른 퀸이 있거나, 대각선에 다른 퀸이 있는지 확인
                if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                    return false;
                }
            }
            return true;  // 공격 범위에 없으면 true 반환
        }

    }

    public static class 양궁대회 {
        static int maxDiff = 0; // 가장 큰 점수 차이를 저장할 변수
        static int[] bestComb = {-1}; // 최종 결과를 저장할 배열

        public static int[] solution(int n, int[] info) {
            int[] ryanScores = new int[11]; // 라이언이 각 점수에 쏜 화살 수를 저장할 배열
            maxDiff = 0;
            bestComb = new int[11];

            dfs(n, 0, ryanScores, info); // DFS(화살 갯수, 구역, 라이언 화살 수 배열, 어피치 점수)

            if (maxDiff == 0) {
                return new int[]{-1};
            }

            return bestComb;
        }

        private static void dfs(int n, int idx, int[] ryanScores, int[] apeachScores) {
            // 화살을 모두 소진했거나 마지막 점수 구역까지 다 탐색한 경우
            if (n == 0 || idx == 11) {
                ryanScores[10] += n; // 남은 화살은 0점 구역에 몰아줌
                int rScore = 0, aScore = 0;

                // 각 점수에서 누가 이겼는지 계산
                for (int i = 0; i < 11; i++) {
                    if (ryanScores[i] > apeachScores[i]) {
                        rScore += 10 - i;
                    } else if (apeachScores[i] > 0) {
                        aScore += 10 - i;
                    }
                }

                int diff = rScore - aScore; // 점수 차이 계산

                // 라이언이 이기고, 점수 차이가 더 큰 경우 또는 낮은 점수를 더 많이 맞힌 경우 갱신
                if (diff > maxDiff || (diff == maxDiff && isBetter(ryanScores, bestComb))) {
                    maxDiff = diff;
                    bestComb = ryanScores.clone();
                }

                ryanScores[10] -= n; // 남은 화살 복구
                return;
            }

            // 해당 점수에 어피치보다 더 많은 화살을 쏘는 경우
            if (n > apeachScores[idx]) {
                ryanScores[idx] = apeachScores[idx] + 1;
                dfs(n - ryanScores[idx], idx + 1, ryanScores, apeachScores);
                ryanScores[idx] = 0; // 백트래킹
            }

            // 해당 점수에 화살을 쏘지 않는 경우
            dfs(n, idx + 1, ryanScores, apeachScores);
        }

        // 더 낮은 점수를 많이 맞힌 배열이 더 좋은 배열인지 비교하는 함수
        private static boolean isBetter(int[] newComb, int[] oldComb) {
            for (int i = 10; i >= 0; i--) {
                if (newComb[i] > oldComb[i]) return true;
                else if (newComb[i] < oldComb[i]) return false;
            }
            return false;
        }

        public static void main(String[] args) {
            int n = 5;
            int[] info = {2,1,1,1,0,0,0,0,0,0,0};
            int[] result = solution(n, info);

            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }

    public static class 양궁대회V2 {

        private static int max;
        private static int[] answer;
        private static int[] apeach;


        // 1번
        private static int getScore(int[] ryan) {
            int score = 0;
            for (int i = 0; i <= 10; i++) {
                if (ryan[i] + apeach[i] > 0) {
                    score += ryan[i] > apeach[i] ? (10 - i) : -(10 - i);
                }
            }
            return score;
        }

        // 2번
        private static void calculateDiff(int[] ryan) {
            int score = getScore(ryan);
            if (max < score) {
                max = score;
                answer = ryan.clone();
            } else if (max > 0 && max == score) {
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] != ryan[i]) {
                        if (answer[i] < ryan[i]) {
                            answer = ryan.clone();
                        }
                        break;
                    }
                }
            }
        }

        // 3번
        private static void backtrack(int n, int idx, int[] ryan) {
            if (n == 0) {
                calculateDiff(ryan);
                return;
            }

            for (int i = idx; i <= 10 ; i++) {
                int cnt = Math.min(n, apeach[i] + 1);
                ryan[i] = cnt;
                backtrack(n - cnt, i + 1, ryan);
                ryan[i] = 0;
            }
        }

        public static int[] solution(int n, int[] info) {
            apeach = info;
            max = 0;
            // 화살의 갯수, 과녁? , 라이언
            backtrack(n, 0, new int[11]);
            // 4번
            return max == 0 ? new int[]{-1} : answer;
        }

    }
}
