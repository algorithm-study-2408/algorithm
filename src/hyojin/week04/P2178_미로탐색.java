package hyojin.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class P2178_미로탐색 {
    // 이동 방향
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited; // 방문 변수
    static int[][] A;           // 미로 변수
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int [N][M];
        visited = new boolean[N][M];

        // 미로 생성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            char[] c = line.toCharArray();
            for (int j = 0; j < M; j++) {
                A[i][j] = c[j] - '0';
            }
        }

        // 너비 우선 탐색 시작
        BFS(0, 0);

        System.out.println(A[N - 1][M - 1]);

        System.out.println("최종 미로: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    // 너비 우선 탐색
    private static void BFS(int i, int j) {
        // 0,0
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[] {i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            // 현재 좌표
            int[] current_point = queue.pollFirst();

            for (int k = 0; k < 4; k++) {
                // 좌표 이동
                int x = current_point[0] + dx[k];
                int y = current_point[1] + dy[k];

                // 이동한 곳이 조건에 부합한지 확인 (이동한 좌표가 미로 안에 존재함)
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    // 이동한 좌표가 0이 아니고, 방문한 적이 없음
                    if (A[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        // 깊이 추가
                        A[x][y] = A[current_point[0]][current_point[1]] + 1;
                        // 큐에 다음 좌표 추가
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }

}
