package gyeol.week01;

import java.io.*;
import java.util.StringTokenizer;

public class 수들의_합_5 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());

        // 포인터와 배열 생성
        int left = 0;
        int right = 0;
        int[] arr = new int[N];

        // 포인터로 가르키기 위한 배열에 값 넣기
        // O(N)
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        // 갯수 세기
        // O(N)
        int count = 1;
        int sum = 0;
        while (right < N){
            if(sum < N){
                sum += arr[right];
                right++;
            } else if(sum > N){
                sum -= arr[left];
                left++;
            } else {
                // sum과 N이 같다면 카운트 증가
                count++;
                sum -= arr[left];
                left++;
            }
        }

        bw.write(Integer.toString(count));  // 문자열로 변환하여 출력
        bw.flush();
        bw.close();
    }
}