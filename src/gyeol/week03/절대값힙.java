package gyeol.week03;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절대값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        // 1. 변수를 받을 ArrayList 생성
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            // 2-1. 0이 아니면 q에 넣는다.
            if (list.get(i) != 0) {
                pq.add(Math.abs(list.get(i)));
                // 2-2. 0이면
            } else {
                int poll = pq.poll();
                // 3. list에서 삭제를 위한 for문
                for (int j = 0; j < list.size(); j++) {
                    // 4-1. 같은 게 있다면 출력
                    if (poll == list.get(j)) {
                        list.remove(Integer.valueOf(poll));
                        bw.write(String.valueOf(poll));
                        bw.newLine();
                        break;
                    }
                    // 4-2. poll과 list 요소중에 같은 게 없다면 poll에 -부호 붙여서 출력
                    if (poll == Math.abs(list.get(j))) {
                        poll = poll * -1;
                        list.remove(Integer.valueOf(poll));
                        bw.write(String.valueOf(poll));
                        bw.newLine();
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
//0이 아니면 넣고
//0이면 절대값이 가장 낮은 수(우선순위는 음수) 출력