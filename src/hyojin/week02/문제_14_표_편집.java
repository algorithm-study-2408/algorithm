package hyojin.week02;

import java.util.*;

public class 문제_14_표_편집 {
    public static void main(String[] args) {
        // 입출력 선언
        int n = 8;
        int k = 2;
//        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};

        // 정답지
        // 삭제된 행의 인덱스를 저장하는 스택
        Stack<Integer> deleted = new Stack<>();

        // 각 행을 기준으로 연산에 따른 위치를 표시하기 위한 배열
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];

        for (int i = 0; i < n + 2; i++) {
            up[i] = i -1;
            down[i] = i + 1;
        }

        // 현재 위치를 나타내는 인덱스
        k++;

        // 주어진 명령어 배열을 하나씩 처리
        for (String c : cmd) {
            if (c.startsWith("C")) {
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                k = n < down[k] ? up[k] : down[k];
            } else if (c.startsWith("Z")) {
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            } else {
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for (int i = 0; i < x; i++) {
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, '0');

        for (int i : deleted) {
            answer[i - 1] = 'X';
        }

        System.out.println(new String(answer));

    }

    public void 잘못된_코드_기록용() {
        // 입출력 선언
        int n = 8;
        int k = 2;
//        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};

        // 테이블과 결과값 선언
        int[] table = new int[n];
        for (int i = 0; i < n; i++) {
            table[i] = i;
        }
        String[] resultArr = new String[n];
        for (int i = 0; i < n; i++) {
            resultArr[i] = "O";
        }

        // 삭제된 행을 담을 stack 선언
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // 반복문을 통해 명령어 실행
        for (int i = 0; i < cmd.length; i++) {
            String[] s = cmd[i].split(" ");
            int sLen = s.length;
            if (sLen > 1) {
                // 이동 명령어
                String s1 = s[0];
                String s2 = s[1];
                switch (s1) {
                    // 테이블을 벗어나는 경우의 수도 고려해야할 거 같음.
                    case "U":
                        k -= Integer.parseInt(s2);
                        break;
                    case "D":
                        k += Integer.parseInt(s2);
                        break;
                }
            } else {
                // 삭제 또는 복구 명령어
                String s1 = s[0];
                switch (s1) {
                    // C를 수행하면 선택도니 행을 삭제하고 바로 아래행을 선택하지만
                    // 마지막 행일 경우 윗 행을 선택한다
                    case "C":
                        stack.push(k);
                        if (k == n - 1) {
                            k--;
                        } else {
                            k++;
                        }
                        break;
                    case "Z":
                        stack.pop();
                        break;
                }
            }
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int pop = stack.pop();
            resultArr[pop] = "X";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultArr.length; i++) {
            sb.append(resultArr[i]);
        }

        System.out.println(sb.toString());

    }
}
