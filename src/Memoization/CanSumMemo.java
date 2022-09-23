package Memoization;

import java.util.HashMap;
import java.util.Map;

public class CanSumMemo {

  static Map<Integer, Boolean> memo = new HashMap<>();

  static boolean canSum(int targetSum, int[] numbers) {
    if (targetSum == 0) {
      return true;
    }

    if (targetSum < 0) {
      return false;
    }


    for (int i = 0; i < numbers.length; i++) {
      if (memo.containsKey(targetSum - numbers[i])) {
        if (memo.get(targetSum - numbers[i])) {
          return true;
        } else {
          continue;
        }
      }
      if (canSum(targetSum - numbers[i], numbers)) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(canSum(7, new int[] {2, 4}));
  }
}
