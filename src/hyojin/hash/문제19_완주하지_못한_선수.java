package hyojin.hash;

import java.util.HashMap;

public class 문제19_완주하지_못한_선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};

        String name = solution(participant, completion);
        System.out.println(name);
    }

    private static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String name : participant) {
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            if (hashMap.getOrDefault(name, 0) == 0) {
                return name;
            }
            hashMap.put(name, hashMap.get(name) - 1);
        }
        return null;
    }
}
