package hyojin.week04;
// 문제 : N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
 * 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
 */
public class P1920_수_찾기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 토큰의 개수만큼 배열을 생성
        int[] N = new int[st.countTokens()];

        // 배열에 값 저장
        for (int i = 0; i < N.length; i++) {
            N[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        // 토큰의 개수만큼 배열을 생성
        int[] M = new int[st.countTokens()];

        // 배열에 값 저장
        for (int i = 0; i < M.length; i++) {
            M[i] = Integer.parseInt(st.nextToken());
        }
        solution1(N.length, N, M.length, M);

    }

    private static void solution1(int N, int[] n, int M, int[] m) {

    }
}
