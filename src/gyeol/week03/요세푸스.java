package gyeol.week03;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 요세푸스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // N과 K는 1000이하 자연수
        // N: 사람의 수
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // K: 임의의 수
        int K = Integer.parseInt(st.nextToken());

        // 1. queue에 1부터 N까지 삽입
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.addLast(i);
        }

        // 2. q가 하나 남을 때 까지 K - 1까지 poll하고 다시 삽입, K는 poll
        // N-1번 하면 마지막
        int poll = 0;
        for (int i = 1; i < N ;i++) {
            for (int j = 1; j < K ;j++) {
                // K - 1 번 poll
                poll = q.pollFirst();
                q.addLast(poll);
            }
            q.pollFirst();
        }

        poll = q.pollFirst();
        bw.write(String.valueOf(poll));

        bw.flush();
        bw.close();
        br.close();
    }
}
// for문으로 1부터 시작해서 N까지 K씩 증가