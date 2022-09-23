package Tabulation;

public class FibTabulation {

  // Classic (more general) tabulation.. will follow a similar structure for other problems.

  public static Long fib(int n) {
    long[] table = new long[n+1];
    table[1] = 1;

    for (int i = 0; i < n; i++) {
      table[i + 1] += table[i];
      if (i + 2 <= n) {
        table[i + 2] += table[i];
      }
    }

    return table[n];
  }

  // Saving some space when using tabulation.. so this is using just 2 variables rather than an array.

  public static Long fib2(int n) {
    long first = 1;
    long second = 1;

    for (int i = 3; i <= n; i++) {
      long temp = first + second;
      first = second;
      second = temp;
    }

    return second;
  }

  public static void main(String[] args) {
    System.out.println(fib(5));
    System.out.println(fib(7));
    System.out.println(fib(8));
    System.out.println(fib(50));

    System.out.println(fib2(5));
    System.out.println(fib(8));
    System.out.println(fib(50));
  }
}
