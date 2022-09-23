package Tabulation;

import java.util.ArrayList;
import java.util.List;

public class BestSumTab {

  public static List<Integer> bestSum(int targetSum, int[] numbers) {

    List<Integer>[] table = (List<Integer>[]) new List[targetSum + 1];

    table[0] = new ArrayList<>();

    for (int i = 0; i <= targetSum; i++) {
      if (table[i] != null) {

        for (int number : numbers) {
          if (i + number <= targetSum) {
            List<Integer> newAr = new ArrayList<>(table[i]);
            newAr.add(number);

            if (table[i + number] == null || newAr.size() < table[i + number].size()) {
              table[i + number] = newAr;
            }
          }
        }
      }
    }

    return table[targetSum];

  }

  public static void main(String[] args) {
    System.out.println(bestSum(8, new int[] {2, 3, 5}));
    System.out.println(bestSum(7, new int[] {5, 3, 4, 7}));
    System.out.println(bestSum(8, new int[] {1, 4, 5}));
    System.out.println(bestSum(100, new int[] {1, 2, 5, 25}));
  }
}
