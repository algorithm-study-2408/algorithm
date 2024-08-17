package hyojin.week02;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P10828 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력 받을 명령어의 개수
        int n = sc.nextInt();
        sc.nextLine(); // nextInt() 호출 후 버퍼에 남아있는 줄 바꿈 문자 제거

        // 명령어를 저장할 배열 생성
        String[] cmd = new String[n];

        // 명령어 입력 받기
        for (int i = 0; i < n; i++) {
            cmd[i] = sc.nextLine(); // 한 줄씩 읽어서 배열에 저장
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] s = cmd[i].split(" ");
            switch (s[0]) {
                case "push":
                    String s1 = s[1];
                    int i1 = Integer.parseInt(s1);
                    stack.push(i1);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }
    }
}
