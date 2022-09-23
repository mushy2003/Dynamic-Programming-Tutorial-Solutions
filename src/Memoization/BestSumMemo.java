package Memoization;

import java.util.*;

public class BestSumMemo {

  static Map<Integer, List<Integer>> memo = new HashMap<>();

  static List<Integer> bestSum(int targetSum, int[] numbers) {

    if (targetSum == 0) {
      return new ArrayList<Integer>();
    }

    if (targetSum < 0) {
      return null;
    }

    if (memo.containsKey(targetSum)) {
      return memo.get(targetSum);
    }


    List<Integer> minRes = null;
    for (int i = 0; i < numbers.length; i++) {
      List<Integer> subRes = bestSum(targetSum - numbers[i], numbers);

      if (subRes != null) {
        // Need to copy list to another list as otherwise you would be directly modifying the list object that is stored in the map... which would lead to bugs.
        List<Integer> tempRes = new ArrayList<>(subRes);
        tempRes.add(numbers[i]);

        if (minRes == null || subRes.size() < minRes.size()) {
          minRes = tempRes;
        }
      }
    }

    memo.put(targetSum, minRes);
    return minRes;
  }



  public static void main(String[] args) {
    // System.out.println(bestSum(8, new int[] {2, 3, 5}));
    // System.out.println(bestSum(8, new int[] {1, 4, 5}));
    System.out.println(bestSum(100, new int[] {1, 2, 5, 25}));
  }
}
