package hyojin.hash;

import java.io.IOException;
import java.util.HashSet;

public class 문제18_두_개의_수로_특정값_만들기 {

    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 8};
        int tartget = 6;
        solution(arr, tartget);
    }

    private static boolean solution(int[] arr, int tartget) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : arr) {
            if (hashSet.contains(tartget - i)) {
                return true;
            }
            hashSet.add(i);
        }
        return false;
    }

}
