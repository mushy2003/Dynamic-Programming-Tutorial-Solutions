package Tabulation;

public class CanSumTab {

  public static boolean canSum(int target, int[] numbers) {
    final boolean[] table = new boolean[target + 1];
    table[0] = true;

    for (int i = 0; i < table.length; i++) {
      if (!table[i]) {
        continue;
      }

      for (Integer number : numbers) {
        if (i + number <= target) {
          table[i + number] = true;

          if (i + number == target) {
            // Here we are returning early as we know we can make the target.
            // So we may not finish completing the table before we return.
            return true;
          }
        }
      }
    }

    return false;

  }

  public static void main(String[] args) {
    System.out.println(canSum(7, new int[] {5, 3, 4}));
    System.out.println(canSum(7, new int[] {2, 4}));
    System.out.println(canSum(8, new int[] {2, 3, 5}));
    System.out.println(canSum(300, new int[] {7, 14}));
  }
}
