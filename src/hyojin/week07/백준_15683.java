package hyojin.week07;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * [시뮬레이션] https://www.acmicpc.net/problem/15683
 */
public class 백준_15683 {
    static int N, M;
    static int[][] map;
    static int minValue ;
    static ArrayList<int[]> cctvs = new ArrayList<>();

    // 시계방향, 상, 우, 하, 좌 = 북, 동, 남, 서
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    // 시계방향, 0 = 상, 1 = 우, 2, = 하, 3 = 좌
    public static int[][][] cctvDirection =
            {
                { {0} },
                { {0}, {1}, {2}, {3} },
                { {1, 3}, {0, 2} },
                { {0, 1}, {1, 2}, {2, 3}, {3, 0} },
                { {0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3} },
                { {0, 1, 2, 3} }
            };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new int[] { i, j, map[i][j] });
                }
            }
        }

        dfs(0, map);
    }

    private static void dfs(int depth, int[][] map) {

        // cctv 방향을 설정할 떄마다 depth가 증가한다.
        if (depth == cctvs.size()) {
            // 모든 CCTV의 방향이 설정된 경우 사각지대 계산
            minValue = Math.min(minValue, minCheck(map));
            return;
        }

        int[] cctv = cctvs.get(depth);
        int x = cctv[0], y = cctv[1], type = cctv[2];

        // CCTV의 종류에 따른 모든 방향을 탐색
        for (int[] dirs : cctvDirection[type]) {
            int[][] tempMap = copyMap(map); // 새로운 맵 복사
            for (int dir : dirs) {
                watch(tempMap, x, y, dir);
            }
            dfs(depth + 1, tempMap);
        }
    }

    // 주어진 방향으로 CCTV 감시 처리
    public static void watch(int[][] map, int x, int y, int dir) {
        while (true) {
            x += dx[dir];
            y += dy[dir];
            // 범위를 넘거나 벽을 만나면 종료
            if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 6) {
                break;
            }

            if (map[x][y] == 0) { // 빈 칸이라면 감시
                map[x][y] = -1;
            }
        }
    }

    // 지도가 완성되었으면 사각지대 계산
    private static int minCheck(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // 맵 복사
    public static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

}
