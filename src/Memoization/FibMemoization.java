package Memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibMemoization {

  static Map<Integer, Integer> memo = new HashMap<>();

  public static void main(String[] args) {
    System.out.println(fib(30));
  }

  public static int fib(int n) {
    if (n <= 2) {
      return 1;
    }

    if (memo.containsKey(n)) {
      return memo.get(n);
    }

    int res = fib(n-1) + fib(n-2);

    memo.put(n, res);

    return res;

  }
}
