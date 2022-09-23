package Memoization;

import java.util.*;

public class HowSumMemo {

  static Map<Integer, List<Integer>> memo = new HashMap<>();

  static Integer[] howSum(int targetSum, int[] numbers) {
    List<Integer> currRes = new ArrayList<>();
    List<Integer> res = howSum(targetSum, numbers, currRes);

    if (res != null) {
      return res.toArray(Integer[] :: new);
    }

    return null;
  }

  static List<Integer> howSum(int targetSum, int[] numbers, List<Integer> currRes) {
    if (targetSum == 0) {
      return currRes;
    }

    if (targetSum < 0) {
      return null;
    }

    if (memo.containsKey(targetSum)) {
      return memo.get(targetSum);
    }

    for (int i = 0; i < numbers.length; i++) {
      currRes.add(numbers[i]);
      List<Integer> subRes = howSum(targetSum - numbers[i], numbers, currRes);
      memo.put(targetSum, subRes);

      if (subRes != null) {
        return subRes;
      }
      currRes.remove((Integer) numbers[i]);
    }

    return null;
  }

  public static void main(String[] args) {
    //System.out.println(Arrays.toString(howSum(7, new int[]{2, 3})));
    //System.out.println(Arrays.toString(howSum(7, new int[] {5, 3, 4, 7})));
    //System.out.println(Arrays.toString(howSum(7, new int[] {2, 4})));
    //System.out.println(Arrays.toString(howSum(8, new int[] {2, 3, 5})));
    System.out.println(Arrays.toString(howSum(300, new int[] {7, 14})));
  }
}
