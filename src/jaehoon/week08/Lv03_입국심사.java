package jaehoon.week08;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Lv03_입국심사 {

  public static long solution(int n, int[] times) {
    // 1. 입국심사관 리스트 생성
    List<Passporter> passporters = new ArrayList<>();
    for (int time : times) {
      passporters.add(new Passporter(time));
    }

    for (Passporter passporter : passporters) {
      System.out.println("passporter = " + passporter);
    }

    // 2. 큐에 기다리는 사람 넣기
    ArrayDeque<Integer> q = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      q.addLast(i);
    }

    // 3. 총시간을 확인하는 변수
    long total = 0;

    // 4. 큐에서 사람을 꺼내면서 입국 심사 (큐가 비어있고 현재 심사하는 사람이 없으면 종료)
    while (true) {
      total++; // 시간 증가

      // 4-1. 입국 심사관에 기다리는 사람 할당
      for (Passporter in : passporters) {
        // 심사 가능하면 큐에서 사람제거
        if(in.isAvailable() && !q.isEmpty()) {
          q.removeFirst();
          // 심사시작하는 플래그 추가
        }

        // 심사관 심사시간 카운트
        in.increaseTime();
      }

      // 4-2. 기다리는 사람이 없고 현재 심사받고 있는 사람도 없으면 while 종료
      if (q.isEmpty() && !isProcess(passporters)) {
        break; // 심사받고 있는 인원이 없으면 while문 종료
      }
    }

    return total;
  }

  // 현재 모든 심사관이 심사 중인지 확인하는 함수
  private static boolean isProcess(List<Passporter> passporters) {
    for (Passporter passporter : passporters) {
      // 심사중이면 true 리턴
      if (!passporter.isAvailable()) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int n = 6;
    int[] times = {7, 10};
    long result = solution(n, times);
    System.out.println("result = " + result);
  }
}

// 입국 심사관 객체
class Passporter {

  boolean isAvailable;

  int completeTime;

  int currentTime;

  public Passporter(int completeTime) {
    this.isAvailable = false;
    this.completeTime = completeTime;
    this.currentTime = 0;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public int getCurrentTime() {
    return currentTime;
  }

  public void increaseTime() {
    this.currentTime++;
    if (this.currentTime == completeTime) {
      this.isAvailable = true;
      this.currentTime = 0;
    }
  }

  @Override
  public String toString() {
    return "Passporter{" +
        "isAvailable=" + isAvailable +
        ", completeTime=" + completeTime +
        ", currentTime=" + currentTime +
        '}';
  }
}
