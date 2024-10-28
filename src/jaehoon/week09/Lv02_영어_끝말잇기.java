package jaehoon.week09;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Lv02_영어_끝말잇기 {

  public static void main(String[] args) {
    int n = 2;
    String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

    int[] results1 = solution1(n, words);
    System.out.println("results = " + Arrays.toString(results1));

    int[] results2 = solution2(n, words);
    System.out.println("results = " + Arrays.toString(results2));

  }

  // 내풀이
  public static int[] solution1(int n, String[] words) {
    int[] answer = new int[2];

    // 1. 끝말잇기를 하는 사람의 차례를 저장할 map 선언 (1부터 초기화)
    // 끝말잇기를 하는 사람의 순서를 저장하기위한 큐 초기화
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayDeque<Integer> q = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      map.put(i, 0);
      q.addLast(i);
    } // n이 2이라면 1:0, 2:0

    // 2. 끝말잇기 중복을 확인하기 위한 set
    HashSet<String> set = new HashSet<>();

    // 3. words를 순회하면서 끝말잇기 진행
    for (int i = 0; i < words.length; i++) {
      Integer person = q.removeFirst();

      // 첫번째 문자인 경우
      // 한글자 안됨
      if (i == 0) {
        if (words[i].length() <= 1) {
          // 종료
          answer[0] = person;
          answer[1] = map.get(person) + 1;
          break;
        } else {
          map.put(person, map.get(person) + 1);
          set.add(words[i]);
          q.addLast(person);
          continue;
        }
      }

      // 첫번째 이후 문자인 경우
      // 조건1: 이전에 등장했던 단어인지 확인
      if (set.contains(words[i])) {
        // 종료
        answer[0] = person;
        answer[1] = map.get(person) + 1;
        break;
      }
      // 조건2: 올바른 끝말잇기 단어인지 확인
      if (!rightWord(words[i - 1], words[i])) {
        // 종료
        answer[0] = person;
        answer[1] = map.get(person) + 1;
        break;
      }

      // 3-3.끝말잇기 계속 진행
      map.put(person, map.get(person) + 1);
      set.add(words[i]);
      q.addLast(person);
    }
    return answer;
  }

  public static boolean rightWord(String previousWord, String currentWord) {
    // 현재 문자가 한글자인지 확인
    if (currentWord.length() <= 1) {
      return false;
    }

    // 앞에 나온 문자의 뒷글자가 시작글자인지 확인
    if (!lastIndexChar(previousWord).equals(firstIndexChar(currentWord))) {
      return false;
    }

    return true;
  }

  public static Character lastIndexChar(String str) {
    return str.charAt(str.length() - 1);
  }

  public static Character firstIndexChar(String str) {
    return str.charAt(0);
  }

  public static int[] solution2(int n, String[] words) {
    // 중복단어를 확인하기 위한 set
    HashSet<String> userWords = new HashSet<>();

    // 첫 단어 초기화
    int person, turn;
    userWords.add(words[0]);
    char lastChar = words[0].charAt(words[0].length() - 1);

    // 1글자인 경우 종료
    if (words[0].length() <= 1) {
      return new int[]{1, 1};
    }

    // 2번째 단어부터 끝말잇기 진행
    for (int i = 1; i < words.length; i++) {
      person = (i % n) + 1;
      turn = (i / n) + 1;
      String word = words[i];

      // 조건: 한글자이거나 중복 단어이거나 끝말잇기 규칙 위반
      if (word.length() <= 1 || userWords.contains(word) || word.charAt(0) != lastChar) {
        return new int[]{person, turn};
      }

      // 단어 갱신
      userWords.add(word);
      lastChar = word.charAt(word.length() - 1);
    }

    // 문제 없이 끝날 경우
    return new int[]{0, 0};
  }

}
