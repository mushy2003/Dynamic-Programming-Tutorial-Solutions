package Tabulation;

import java.util.ArrayList;
import java.util.List;

public class HowSumTab {

  public static List<Integer> howSum(int targetSum, int[] numbers) {
    final List<List<Integer>> table = new ArrayList<>(targetSum + 1);
    table.add(0, new ArrayList<>());


    for (int i = 1; i <= targetSum; i++) {
      table.add(null);
    }

    for (int i = 0; i <= targetSum; i++) {

      if (table.get(i) == null) {
        continue;
      }

      for (int number : numbers) {
        List<Integer> newAr = new ArrayList<>(table.get(i));
        newAr.add(number);
        if (i + number <= targetSum && table.get(i + number) == null) {
          table.add(i + number, newAr);

          if (i + number == targetSum) {
            return newAr;
          }
        }
      }
    }

    return null;
  }

  public static void main(String[] args) {
    System.out.println(howSum(7, new int[] {5, 3, 4}));
    System.out.println(howSum(7, new int[] {5, 3, 4, 7}));
    System.out.println(howSum(7, new int[] {2, 4}));
    System.out.println(howSum(7, new int[] {2, 3}));
    System.out.println(howSum(8, new int[] {2, 3, 5}));
    System.out.println(howSum(300, new int[] {7, 14}));
  }
}
