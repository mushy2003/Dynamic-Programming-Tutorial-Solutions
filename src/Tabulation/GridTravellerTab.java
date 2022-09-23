package Tabulation;

public class GridTravellerTab {

  public static long gridTraveler(int m, int n) {
    final long[][] table = new long[m+1][n+1];

    table[1][1] = 1;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (i+1 <= m) {
          table[i+1][j] += table[i][j];
        }

        if (j+1 <= n) {
          table[i][j+1] += table[i][j];
        }

      }
    }

    return table[m][n];
  }

  public static void main(String[] args) {
    System.out.println(gridTraveler(1, 1));
    System.out.println(gridTraveler(2, 3));
    System.out.println(gridTraveler(3, 2));
    System.out.println(gridTraveler(3, 3));
    System.out.println(gridTraveler(18, 18));
  }
}
