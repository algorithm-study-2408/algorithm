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

        // 트리 구조를 사용하여, BFS 최종 값들은 구해서 target 값과 같을 경우 카운트하기
        int count = 0;

        // 트리 구조를 사용한 BFS로 접근
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode(0, 0));

        // BFS 순회
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
