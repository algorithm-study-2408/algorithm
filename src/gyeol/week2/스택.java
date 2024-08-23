package gyeol.week2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class 스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());

        ArrayDeque<String> d = new ArrayDeque<>();
        String next = "";

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            next = st.nextToken();
            //pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            if("pop".equals(next)) {
                if(!d.isEmpty()) {
                    bw.write(d.pollLast()+"\n");
                } else {
                    bw.write("-1\n");
                }
                //size: 스택에 들어있는 정수의 개수를 출력한다.
            } else if("size".equals(next)) {
                bw.write(d.size()+"\n");
                //empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
            } else if("empty".equals(next)) {
                if(d.isEmpty()){
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
                //top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            } else if("top".equals(next)) {
                if(d.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(d.peekLast()+"\n");
                }
                //push X: 정수 X를 스택에 넣는 연산이다.
            } else if("push".equals(next)) {
                next = st.nextToken();
                d.addLast(next);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
