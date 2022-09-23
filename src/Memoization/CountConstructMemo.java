package Memoization;

import java.util.HashMap;
import java.util.Map;

public class CountConstructMemo {

  static Map<String, Integer> memo = new HashMap<>();
  static int countConstruct(String target, String[] wordBank) {
    if (target.isEmpty()) {
      return 1;
    }

    if (memo.containsKey(target)) {
      return memo.get(target);
    }

    int count = 0;
    for (String word : wordBank) {
      if (target.startsWith(word)) {
        count += countConstruct(target.substring(word.length()), wordBank);
      }
    }

    memo.put(target, count);
    return count;
  }

  public static void main(String[] args) {
    //System.out.println(countConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"}));
    System.out.println(countConstruct("purple", new String[] {"purp", "p", "ur", "le", "purpl"}));
  }
}
