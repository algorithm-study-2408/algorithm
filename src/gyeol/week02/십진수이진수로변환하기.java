package gyeol.week02;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 십진수이진수로변환하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // 1. N을 0이 될 때 까지 나누기
        while (N != 0) {
            // 2. 나온 나머지를 스택에 넣기
            stack.addLast(N % 2);
            N = N / 2;
        }
        // 3. 스택에서 꺼내서 StringBuffer에 append
        int size = stack.size();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pollLast());
        }

        // 4. String 형태로 변환하여 출력
        bw.write(sb.toString());  // 문자열로 변환하여 출력
        bw.flush();
        bw.close();
        br.close();
    }
}
