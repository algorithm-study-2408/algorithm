package gyeol.week04;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 수찾기 {

    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 행
        int M = Integer.parseInt(st.nextToken());   // 열
        // 미로 배열 생성
        int[][] maze = new int[N][M];
        // 미로 생성
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        boolean[][] visited = new boolean[N][M];    // 방문기록
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 시작 세팅
        queue.addLast(new int[]{0, 0, 1}); // 거리계산편의을 위해 시작 거리 1
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 맵의 끝에 도달했을 경우 distance 출력
            if (x == N - 1 && y == M - 1) {
                bw.write(String.valueOf(distance));
                bw.flush();
                bw.close();
                br.close();
                return;
            }

            for(int i = 0 ; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 바깥으로 나가지 않거나 숫자가 1인 경우 distance++
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                    queue.addLast(new int[]{nx, ny, ++distance});
                    visited[nx][ny] = true;
                }
            }
        }

        // 끝에 도달하지 못했으면 -1 출력
        bw.write(-1);
        bw.flush();
        bw.close();
        br.close();
    }
}