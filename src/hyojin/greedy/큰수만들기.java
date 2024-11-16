package hyojin.greedy;

// https://school.programmers.co.kr/learn/courses/30/lessons/42883

public class 큰수만들기 {
    public static void main(String[] args) {
        String number1 = "1924";
        int k1 = 2;
        System.out.println(solution(number1, k1)); // "94"

        String number2 = "1231234";
        int k2 = 3;
        System.out.println(solution(number2, k2)); // "3234"

        String number3 = "4177252841";
        int k3 = 4;
        System.out.println(solution(number3, k3)); // "775841
    }

        public static String solution(String number, int k) {
            String answer = "";

            int idx = 0;
            StringBuilder sb = new StringBuilder();

            // 앞에서 부터 (전체길이 - k) 수 중 가장 큰 수 선택
            // 선택한 수 다음 인덱스 부터 탐색 범위를 한칸씩 늘려가며 반복 탐색
            for(int i = 0; i < number.length() - k; i++) {
                char max = 0;
                for(int j = idx; j <= i + k; j++) {
                    if(max < number.charAt(j)) {
                        max = number.charAt(j);
                        idx = j + 1;
                    }
                    if(max == '9') break;
                }
                sb.append(max);
            }

            return sb.toString();
        }

}
