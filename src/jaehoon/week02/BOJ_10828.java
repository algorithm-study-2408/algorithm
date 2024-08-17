package jaehoon.week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_10828 {

  private final ArrayDeque<Integer> stack;

  public BOJ_10828() {
    this.stack = new ArrayDeque<>();
  }

  public Integer command(String command, Integer num) {
    switch (command) {
      case "push":
        this.push(num);
        return null;
      case "pop":
        return this.pop();
      case "size":
        return this.size();
      case "empty":
        return this.empty();
      case "top":
        return this.top();
      default:
        throw new IllegalStateException("Unexpected command: " + command);
    }
  }

  public void push(int x) {
    stack.push(x);
  }

  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.pop();
  }

  public int size() {
    return stack.size();
  }

  public int empty() {
    return stack.isEmpty() ? 1 : 0;
  }

  public int top() {
    if (stack.isEmpty()) {
      return -1;
    }
    return stack.peek();
  }

  public static void main(String[] args) {
    BOJ_10828 main = new BOJ_10828();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      int n = Integer.parseInt(br.readLine());

      for (int i = 0; i < n; i++) {
        String[] input = br.readLine().split(" ");

        String command = input[0];
        Integer num = input.length > 1 ? Integer.parseInt(input[1]) : null;
        Integer result = main.command(command, num);
        if (result != null) {
          System.out.println(result);
        }
      }
    } catch (Exception ignore) {
    }
  }
}
