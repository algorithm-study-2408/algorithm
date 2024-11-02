package gyeol.sort;

import java.util.Arrays;

public class 파일명_정렬 {
    public String[] solution(String[] files) {
        Arrays.sort(files, (file1, file2) -> {
            // HEAD, NUMBER을 관리할 배열 -> TAIL은 정렬에 영향을 주지 않기 때문에 넣지 않음
            String[] file1DivArr = {"", ""};
            String[] file2DivArr = {"", ""};

            // checkNum과 checkText 메서드로 HEAD, NUMBER를 나눈다.
            // file1의 HEAD, NUMBER나누기
            int file1Div1 = checkNum(file1);
            file1DivArr[0] = file1.substring(0, file1Div1);
            int file1Div2 = checkText(file1, file1Div1);
            file1DivArr[1] = file1.substring(file1Div1, file1Div2);
            // file2의 HEAD, NUMBER나누기
            int file2Div1 = checkNum(file2);
            file2DivArr[0] = file2.substring(0, file2Div1);
            int file2Div2 = checkText(file2, file2Div1);
            file2DivArr[1] = file2.substring(file2Div1, file2Div2);

            // 정렬
            if (file1DivArr[0].equalsIgnoreCase(file2DivArr[0])) {
                // 1. HEAD와 NUMBER가 같으면 정렬하지 않는다.
                if (Integer.parseInt(file1DivArr[1])
                        == Integer.parseInt(file2DivArr[1])) {
                    return 0;
                }
                // 2. HEAD가 같고 NUMBER가 같지 않으면 NUMBER로 정렬한다.
                return Integer.parseInt(file1DivArr[1])
                        - Integer.parseInt(file2DivArr[1]);
            }
            // 3. HEAD가 같지 않으면 그냥 정렬한다.
            return file1DivArr[0].toLowerCase().compareTo(file2DivArr[0].toLowerCase());
        });
        return files;
    }

    // 숫자가 처음 시작하는 index 반환하는 메서드
    private int checkNum(String file) {
        int i = 0;
        for (i = 0; i < file.length(); i++) {
            if (file.charAt(i) >= '0'
                    && file.charAt(i) <= '9') {
                break;
            }
        }
        return i;
    }

    // 파일이름과 숫자가 처음 시작했던 인덱스를 받아
    // 숫자가 처음 시작했던 인덱스 이후에 텍스트가 처음 시작하는 순간을 반환한다.
    private int checkText(String file, int index) {
        int i = 0;
        for (i = index; i < file.length(); i++) {
            if (file.charAt(i) < '0'
                    || file.charAt(i) > '9') {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        파일명_정렬 a = new 파일명_정렬();
        String[] b = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] c = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        System.out.println(a.solution(b));
        System.out.println(a.solution(c));
    }
}
