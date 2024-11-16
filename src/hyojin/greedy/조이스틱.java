package hyojin.greedy;

// https://school.programmers.co.kr/learn/courses/30/lessons/42860

public class 조이스틱 {
    public static void main(String[] args) {
        String name1 = "JEROEN"; // 56
        String name2 = "JAN";    // 23
        System.out.println(solution(name1));
        System.out.println(solution(name2));
    }

    public static int solution(String name) {
        int answer = 0; // 조이스틱 조작 횟수
        int len = name.length();
        int move = name.length() - 1; // 기본 최소 좌우이동 횟수 (좌, 우 커서)

        // 해당 커서 알파벳 변경 최솟값 (위, 아래 커서)
        for (int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 연속된 'A'가 끝나는 지점 찾기
            int next = i + 1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 좌우이동 최소 횟수 구하기 (순서대로 가기 vs 뒤로 돌아가기)
            move = Math.min(move, (i * 2) + len - next);
            move = Math.min(move, (len - next) * 2 + i);
        }
        answer += move;

        return answer;
    }

}
