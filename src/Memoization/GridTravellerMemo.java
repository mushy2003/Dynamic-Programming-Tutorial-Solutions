package Memoization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridTravellerMemo {

  public static void main(String[] args) {
    System.out.println(gridTraveler(3, 3));
  }

  static Map<String, Integer> memo = new HashMap<>();

  static int gridTraveler(int m, int n) {
    if (m == 1 && n == 1) {
      return 0;
    }

    if (m == 1 || n == 1) {
      return 1;
    }

    if (memo.containsKey(" " + m + n)) {
      return memo.get(" " + m + n);
    }

    int res = gridTraveler(m, n-1) + gridTraveler(m-1, n);
    memo.put(" " + m + n, res);

    return res;
  }
}
