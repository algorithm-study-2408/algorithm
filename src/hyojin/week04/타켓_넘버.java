package hyojin.week04;

import java.util.LinkedList;
import java.util.Queue;

public class 타켓_넘버 {

    static class TreeNode {
        int sum;
        int index;

        public TreeNode(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        // 입출력값
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        // 음이 아닌 정수, 순서를 바꾸지 않고 적절히 더하거나 빼서 타켓 넘버를 만듬
        // 트리 구조를 사용하여, BFS 최종 값들은 구해서 target 값과 같을 경우 카운트하기
        int count = 0;

        // 트리노드 타입의 큐 생성
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode(0, 0));

        // 큐 순회
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // 트리 인덱스 비교
            if (current.index == numbers.length) {
                if (current.sum == target) {
                    count++;
                }
            } else {
                // 현재 인덱스 + 1
                queue.add(new TreeNode(current.sum + numbers[current.index], current.index + 1));
                // 현재 인덱스 - 1
                queue.add(new TreeNode(current.sum - numbers[current.index], current.index + 1));
            }
        }

        System.out.println("count = " + count);
    }
}
